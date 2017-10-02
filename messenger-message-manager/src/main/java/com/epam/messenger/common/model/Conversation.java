package com.epam.messenger.common.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Conversation")
public class Conversation implements Serializable {

  private static final long serialVersionUID = -775350535622500549L;

  @Id
  private Long id;
  private Date createDate;
  private Date updateDate;
}
