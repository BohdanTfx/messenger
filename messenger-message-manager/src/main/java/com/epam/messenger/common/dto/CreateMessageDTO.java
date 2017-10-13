package com.epam.messenger.common.dto;

import lombok.Data;

@Data
public class CreateMessageDTO {

  private String text;
  private Long authorId;
  private Long conversationId;
}
