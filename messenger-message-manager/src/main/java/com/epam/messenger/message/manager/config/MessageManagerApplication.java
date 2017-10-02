package com.epam.messenger.message.manager.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessageManagerApplication {

  public static void main(final String[] args) {
    SpringApplication.run(MessageManagerApplication.class, args);
  }
}
