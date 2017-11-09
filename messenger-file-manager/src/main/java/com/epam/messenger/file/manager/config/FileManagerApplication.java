package com.epam.messenger.file.manager.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableSwagger2
public class FileManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FileManagerApplication.class, args);
  }

}
