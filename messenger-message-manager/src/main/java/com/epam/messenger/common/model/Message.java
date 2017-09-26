package com.epam.messenger.common.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Message")
public class Message implements Serializable {

    private static final long serialVersionUID = -2746316451319829735L;

    @Id
    private Long id;
    private Date createDate;
    private Date updateDate;
    private String text;
    private Long authorId;
    private Conversation conversation;

}
