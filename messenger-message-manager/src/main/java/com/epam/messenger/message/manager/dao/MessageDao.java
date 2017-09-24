package com.epam.messenger.message.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.mentorship.common.model.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Long> {

}
