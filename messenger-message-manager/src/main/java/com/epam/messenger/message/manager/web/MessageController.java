package com.epam.messenger.message.manager.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.epam.messenger.common.dto.CreateMessageDTO;
import com.epam.messenger.common.model.Message;
import com.epam.messenger.common.util.MessageTransformer;
import com.epam.messenger.message.manager.service.MessageService;
import com.epam.messenger.message.manager.util.FileConverter;

@RestController
@RequestMapping("message")
public class MessageController {

  private static final String FILE_MANAGER = "FileManager";

  @Autowired
  private MessageService messageService;
  @Autowired
  private LoadBalancerClient loadBalancer;

  private RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/{id}")
  public Message readMessage(@PathVariable Long id) {
    return messageService.read(id);
  }

  @PostMapping
  public Message saveMessage(CreateMessageDTO messageDTO, @RequestParam(required = false) List<MultipartFile> files)
      throws IOException {
    Message message = MessageTransformer.toMessage(messageDTO);
    message.setAttachments(saveAttachments(files));
    return messageService.save(message);
  }

  private List<String> saveAttachments(List<MultipartFile> files) throws IOException {
    if (files == null || files.isEmpty()) {
      return Collections.emptyList();
    }
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();

    List<String> attachments = files.stream().map(file -> {
      try {
        parts.add("files", new FileSystemResource(FileConverter.convert(file)));
      } catch (IOException e) {
        e.printStackTrace();
      }
      return file.getOriginalFilename();
    }).collect(Collectors.toList());

    ServiceInstance instance = loadBalancer.choose(FILE_MANAGER);
    restTemplate.exchange(instance.getUri() + "/files", HttpMethod.POST,
        new HttpEntity<MultiValueMap<String, Object>>(parts, headers), Boolean.class);

    FileConverter.clearTempStorage();
    return attachments;
  }
}
