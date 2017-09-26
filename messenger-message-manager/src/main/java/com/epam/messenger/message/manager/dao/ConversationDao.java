package com.epam.messenger.message.manager.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.epam.messenger.common.model.Conversation;

@Repository
public interface ConversationDao extends MongoRepository<Conversation, Long> {

}
