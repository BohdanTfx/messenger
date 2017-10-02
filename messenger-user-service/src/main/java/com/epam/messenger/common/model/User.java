package com.epam.messenger.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "user")
@Entity
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 177373347256449505L;

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastname;

}
