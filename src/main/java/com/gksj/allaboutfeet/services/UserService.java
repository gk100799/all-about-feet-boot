package com.gksj.allaboutfeet.services;

import com.gksj.allaboutfeet.entity.User;
import com.gksj.allaboutfeet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public void createUser(User user) {
    userRepository.save(user);
  }

  public User getByUsername(String username) {
    return userRepository.findByUsername(username).get(0);
  }

  public Boolean authenticate(String username, String password) throws Exception {
    try {
      User user = this.getByUsername(username);
      if (user.getPassword().equals(password)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    } catch (Exception e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }

}
