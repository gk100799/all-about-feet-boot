package com.gksj.allaboutfeet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "allaboutfeet_productsubs")
public class ProductSubs {

  @Column(name = "pid")
  @Id
  private Integer pid;

  @Column(name = "bname")
  private String bname;

  @Column(name = "cname")
  private String cname;

  @Column(name = "sname")
  private String sname;

  @Column(name = "color")
  private String color;

}
