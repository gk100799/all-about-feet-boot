package com.gksj.allaboutfeet.repository;

import com.gksj.allaboutfeet.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

  List<User> findByUsername(String username);

  @Query("SELECT count(*) FROM User WHERE username=:name")
  Integer userExists(String name);

}
