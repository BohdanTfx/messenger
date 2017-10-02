package com.epam.messenger.message.manager.service;

import com.epam.messenger.common.model.Conversation;

public interface ConversationService {
  Conversation get(Long id);
}
