package com.epam.messenger.file.manager.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableDiscoveryClient
public class FileManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FileManagerApplication.class, args);
  }

}
