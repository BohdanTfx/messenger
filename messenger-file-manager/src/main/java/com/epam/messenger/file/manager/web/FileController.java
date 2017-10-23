package com.epam.messenger.file.manager.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.epam.messenger.file.manager.service.StorageService;

@RestController
@RequestMapping(value = "/files")
public class FileController {

  @Autowired
  private StorageService storageService;

  @GetMapping("/{groupId}")
  public List<String> listFiles(@PathVariable("groupId") Long groupId) throws IOException {
    return storageService.loadAll(groupId.toString())
        .map(path -> MvcUriComponentsBuilder
            .fromMethodName(FileController.class, "downloadFile", groupId, path.getFileName().toString()).build()
            .toString())
        .collect(Collectors.toList());
  }

  @GetMapping("/{groupId}/{filename:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable("groupId") Long groupId,
      @PathVariable("filename") String filename) {
    Resource file = storageService.loadAsResource(groupId + "/" + filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

  @GetMapping(value = "/{groupId}/{filename:.+}", headers = "returnType=FileUrl")
  public String getFileUrl(@PathVariable("groupId") Long groupId, @PathVariable("filename") String filename) {
    return MvcUriComponentsBuilder.fromMethodName(FileController.class, "downloadFile", groupId, filename).build()
        .toString();
  }

  @PostMapping("/{groupId}")
  public Boolean uploadFile(@RequestParam("files") List<MultipartFile> files, @PathVariable("groupId") Long groupId) {
    files.forEach(file -> storageService.store(groupId.toString(), file));
    return true;
  }

}
