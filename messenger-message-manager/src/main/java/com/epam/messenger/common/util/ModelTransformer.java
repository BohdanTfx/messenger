package com.epam.messenger.common.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.messenger.common.dto.ConversationDTO;
import com.epam.messenger.common.dto.CreateMessageDTO;
import com.epam.messenger.common.model.Conversation;
import com.epam.messenger.common.model.Message;
import com.epam.messenger.message.manager.service.ConversationService;

@Component
public class ModelTransformer {

  private static ConversationService conversationServiceStatic;

  @Autowired
  private ConversationService conversationService;

  @PostConstruct
  public void init() {
    conversationServiceStatic = conversationService;
  }

  public static Message toMessage(CreateMessageDTO dto) {
    Message message = new Message();
    message.setText(dto.getText());
    message.setAuthorId(dto.getAuthorId());
    message.setConversation(conversationServiceStatic.get(dto.getConversationId()));
    return message;
  }

  public static Conversation toConversation(ConversationDTO dto) {
    Conversation conversation = new Conversation();
    conversation.setAuthorId(dto.getAuthorId());
    conversation.setParticipants(dto.getParticipants());
    return conversation;
  }
}
