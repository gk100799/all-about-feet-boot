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

    public void getByUsername(String username) {
        userRepository.
    }

}
