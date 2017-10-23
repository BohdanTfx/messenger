package com.epam.messenger.message.manager.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.epam.messenger.common.model.Message;

@Repository
public interface MessageDao extends MongoRepository<Message, Long> {
  List<Message> findByConversation(Long id);
}
