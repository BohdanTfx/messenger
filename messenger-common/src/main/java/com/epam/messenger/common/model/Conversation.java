package com.epam.messenger.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Conversation implements Serializable {

    private static final long serialVersionUID = -775350535622500549L;

    @Id
    @GeneratedValue
    private Long id;
}
