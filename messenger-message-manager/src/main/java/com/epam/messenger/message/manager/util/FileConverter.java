package com.epam.messenger.message.manager.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileConverter {

  private static final String TMP_STORAGE = "tmp-storage/";

  public static File convert(MultipartFile file) throws IOException {
    File targetFile = new File(TMP_STORAGE + file.getOriginalFilename());

    createIfNecessary(targetFile);

    Files.copy(file.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

    return targetFile;
  }

  private static void createIfNecessary(File file) throws IOException {
    Path path = file.toPath();

    if (!Files.exists(path)) {
      Files.createDirectories(path);
    }
  }

  public static void clearTempStorage() throws IOException {
    FileSystemUtils.deleteRecursively(new File(TMP_STORAGE));
  }
}
