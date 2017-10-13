package com.epam.messenger.common.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MessageDTO {

  private Long id;
  private Date createDate;
  private Date updateDate;
  private String text;
  private Long authorId;
  private Long conversationId;
  private List<String> attachmentNames = new ArrayList<>();
}
