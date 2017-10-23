package com.epam.messenger.message.manager.web.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.Headers;

@FeignClient(name = "file-manager", url = "${clients.filemanager.url}")
public interface FileManagerClient {

  @GetMapping("/files" + "/{groupId}/{filename:.+}")
  @Headers("returnType: FileUrl")
  String getFileUrl(@PathVariable("groupId") Long groupId, @PathVariable("filename") String filename);

  @GetMapping("/files/{groupId}")
  List<String> listFiles(@PathVariable("groupId") Long messageId);
}
