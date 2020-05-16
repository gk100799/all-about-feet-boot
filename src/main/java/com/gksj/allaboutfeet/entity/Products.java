package com.gksj.allaboutfeet.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="allaboutfeet_products")
public class Products implements Serializable {

    @Column(name = "pid")
    @Id
    private Integer pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "price")
    private int price;

    @Column(name = "desciption")
    private String desciption;

    @Column(name = "imagename")
    private String imagename;
}
