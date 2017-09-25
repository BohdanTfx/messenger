package com.epam.messenger.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MessageDTO {

    private Long id;
    private Date createdDate;
    private String text;
    private Long authorId;
    private Long conversationId;
}
