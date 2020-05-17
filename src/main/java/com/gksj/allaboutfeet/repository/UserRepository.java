package com.gksj.allaboutfeet.repository;

import com.gksj.allaboutfeet.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

  //    @Query("SELECT id,username FROM allaboutfeet_user WHERE username = ?1")
  List<User> findByUsername(String username);

}
