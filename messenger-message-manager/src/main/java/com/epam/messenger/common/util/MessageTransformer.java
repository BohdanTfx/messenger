package com.epam.messenger.common.util;

import com.epam.messenger.common.dto.CreateMessageDTO;
import com.epam.messenger.common.model.Message;

public class MessageTransformer {
  public static Message toMessage(CreateMessageDTO dto) {
    Message message = new Message();
    message.setText(dto.getText());
    message.setAuthorId(dto.getAuthorId());
    // message.setConversation(dto.getConversationId());
    return message;
  }
}
