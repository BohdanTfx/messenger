package com.epam.messenger.user.management.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.epam.messenger.common.model.User;
import com.epam.messenger.user.management.dao.UserDao;
import com.epam.messenger.user.management.service.impl.AuditorAwareImpl;
import com.epam.messenger.user.management.web.UserController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan("com.epam.messenger")
@EnableJpaRepositories(basePackageClasses = UserDao.class)
@EntityScan(basePackageClasses = User.class)
@EnableAutoConfiguration
@EnableJpaAuditing
public class ApplicationConfiguration {

  @Bean
  public AuditorAwareImpl auditorProvider() {
    return new AuditorAwareImpl();
  }

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage(UserController.class.getPackage().getName()))
        .paths(PathSelectors.any()).build();

  }
}
