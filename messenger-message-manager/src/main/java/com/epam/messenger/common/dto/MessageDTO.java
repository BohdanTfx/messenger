package com.epam.messenger.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MessageDTO {

  private Long id;
  private Date createDate;
  private Date updateDate;
  private String text;
  private Long authorId;
  private Long conversationId;
}
