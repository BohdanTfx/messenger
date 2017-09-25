package com.epam.messenger.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = -2746316451319829735L;

    @Id
    @GeneratedValue
    private Long id;
    private Date createdDate;
    private String text;
    private User author;
    private Conversation conversation;

    @PrePersist
    public void preSave() {
	setCreatedDate(new Date());
    }
}
