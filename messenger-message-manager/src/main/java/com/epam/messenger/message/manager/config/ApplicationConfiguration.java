package com.epam.messenger.message.manager.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.epam.messenger.common.model.Message;
import com.epam.messenger.message.manager.dao.MessageDao;
import com.epam.messenger.message.manager.util.FileConverter;
import com.epam.messenger.message.manager.web.MessageController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan("com.epam.messenger")
@EnableMongoRepositories(basePackageClasses = MessageDao.class)
@EntityScan(basePackageClasses = Message.class)
@EnableAutoConfiguration
@EnableScheduling
public class ApplicationConfiguration {
  private static Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage(MessageController.class.getPackage().getName()))
        .paths(PathSelectors.any()).build();

  }

  @Scheduled(fixedDelay = 1000 * 60)
  public void clearTempFileStorage() throws IOException {
    LOG.info("Clearing temp file storage");
    FileConverter.clearTempStorage();
  }
}
