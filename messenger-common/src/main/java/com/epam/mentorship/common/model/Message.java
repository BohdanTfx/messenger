package com.epam.mentorship.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = -2746316451319829735L;

    private Long id;
    private Date createdDate;
    private String text;

}
