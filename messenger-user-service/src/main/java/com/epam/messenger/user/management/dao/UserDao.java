package com.epam.messenger.user.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.messenger.common.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
