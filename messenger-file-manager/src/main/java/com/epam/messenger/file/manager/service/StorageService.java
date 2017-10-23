package com.epam.messenger.file.manager.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

  void store(String groupId, MultipartFile file);

  Stream<Path> loadAll(String groupId);

  Path load(String filename);

  Resource loadAsResource(String filename);

  void deleteAll();
}
