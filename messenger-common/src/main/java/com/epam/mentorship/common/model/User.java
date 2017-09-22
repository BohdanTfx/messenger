package com.epam.mentorship.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 177373347256449505L;

    private Long id;
    private String firstName;
    private String lastname;
    
}
