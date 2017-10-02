package com.epam.messenger.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "SequenceId")
public class SequenceId {

  @Id
  private String id;
  private long seq;

}
