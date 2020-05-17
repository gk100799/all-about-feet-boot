package com.gksj.allaboutfeet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "allaboutboot_cart")
public class Cart implements Serializable {

  @Column(name = "username")
  private String username;

  @Column(name = "pid")
  private Integer pid;

  @Column(name = "size")
  private Integer size;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "id")
  @Id
  private Integer id;

}
