package com.gksj.allaboutfeet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "allaboutfeet_user")
public class User implements Serializable {

  @Column(name = "id")
  @Id
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "first_name")
  private String first_name;

  @Column(name = "last_name")
  private String lastname;

  @Column(name = "email")
  private String email;
//    public List<GrantedAuthority> getAuthorities(){
//        return null;
//    }

}
