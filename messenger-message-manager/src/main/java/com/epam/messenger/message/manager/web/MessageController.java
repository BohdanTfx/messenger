package com.epam.messenger.message.manager.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.epam.messenger.common.model.enums.Service;
import com.epam.messenger.common.util.MessageTransformer;
import com.epam.messenger.message.manager.service.MessageService;
import com.epam.messenger.message.manager.util.FileConverter;
import com.epam.messenger.message.manager.util.ServiceURLProvider;

@RestController
@RequestMapping("message")
public class MessageController {

  @Autowired
  private MessageService messageService;

  private RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/{id}")
  public Message readMessage(@PathVariable Long id) {
    return messageService.read(id);
  }

  @PostMapping
  public Message saveMessage(CreateMessageDTO messageDTO, @RequestParam(required = false) List<MultipartFile> files) {
    Message message = MessageTransformer.toMessage(messageDTO);
    message.setAttachments(saveAttachments(files));
    return messageService.save(message);
  }

  private List<String> saveAttachments(List<MultipartFile> files) {
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

    restTemplate.exchange(ServiceURLProvider.getURL(Service.FILE_MANAGER) + "/files", HttpMethod.POST,
        new HttpEntity<MultiValueMap<String, Object>>(parts, headers), Boolean.class);
    return attachments;
  }
}
