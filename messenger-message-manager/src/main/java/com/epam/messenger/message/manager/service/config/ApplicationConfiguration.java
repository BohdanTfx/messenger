package com.epam.messenger.message.manager.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.epam.messenger")
@EnableJpaRepositories("com.epam.messenger.message.manager.dao")
@EntityScan("com.epam.messenger.common.model")
@EnableAutoConfiguration
public class ApplicationConfiguration {

}
