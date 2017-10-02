package com.epam.messenger.user.management.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.epam.messenger.common.model.User;
import com.epam.messenger.user.management.dao.UserDao;

@Configuration
@ComponentScan("com.epam.messenger")
@EnableJpaRepositories(basePackageClasses = UserDao.class)
@EntityScan(basePackageClasses = User.class)
@EnableAutoConfiguration
public class ApplicationConfiguration {

}
