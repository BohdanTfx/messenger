package com.epam.messenger.file.manager.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

  private final StorageService storageService;

  @Autowired
  public FileController(StorageService storageService) {
    this.storageService = storageService;
  }

  @GetMapping
  public List<String> listFiles(Model model) throws IOException {
    return storageService.loadAll()
        .map(path -> MvcUriComponentsBuilder
            .fromMethodName(FileController.class, "downloadFile", path.getFileName().toString()).build().toString())
        .collect(Collectors.toList());
  }

  @GetMapping("/{filename:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
    Resource file = storageService.loadAsResource(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

  @PostMapping
  public Boolean uploadFile(@RequestParam List<MultipartFile> files) {
    files.forEach(file -> storageService.store(file));
    return true;
  }

}
