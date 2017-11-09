package com.epam.messenger.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AuthServer {
  
  public static void main(String[] args) {
    SpringApplication.run(AuthServer.class, args);
  }
}
