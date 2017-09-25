package com.epam.messenger.message.manager.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.epam.messenger.common.model.Message;
import com.epam.messenger.message.manager.dao.MessageDao;

@Configuration
@ComponentScan("com.epam.messenger")
@EnableMongoRepositories(basePackageClasses = MessageDao.class)
@EntityScan(basePackageClasses = Message.class)
@EnableAutoConfiguration
public class ApplicationConfiguration {

}
