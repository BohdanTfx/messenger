package com.epam.messenger.common.dto;

import java.util.List;

import lombok.Data;

@Data
public class ConversationDTO {
  private Long authorId;
  private List<Long> participants;
}
