package com.gksj.allaboutfeet.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="allaboutfeet_brand")
public class Brands implements Serializable {
    @Column(name="bname")
    @Id
    private String bname;
}
