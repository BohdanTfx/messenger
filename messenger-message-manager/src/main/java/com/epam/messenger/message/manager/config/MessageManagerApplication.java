package com.epam.messenger.message.manager.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class MessageManagerApplication {

  public static void main(final String[] args) {
    SpringApplication.run(MessageManagerApplication.class, args);
  }
}
