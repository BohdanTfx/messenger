package com.epam.messenger.message.manager.service;

import java.util.List;

import com.epam.messenger.common.model.Conversation;
import com.epam.messenger.common.model.Message;

public interface ConversationService {
  Conversation get(Long id);

  Conversation create(Conversation conversation);

  List<Message> findMessages(Long id);
}
