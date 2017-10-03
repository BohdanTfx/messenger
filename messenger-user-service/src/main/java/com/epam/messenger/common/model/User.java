package com.epam.messenger.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Table(name = "user")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

  private static final long serialVersionUID = 177373347256449505L;

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  @CreatedDate
  private Date createDate;
  @LastModifiedDate
  private Date updateDate;

}
