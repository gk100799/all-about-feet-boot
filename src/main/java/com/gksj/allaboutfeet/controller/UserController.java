package com.gksj.allaboutfeet.controller;
//import com.gksj.allaboutfeet.config.JwtTokenUtil;

import com.gksj.allaboutfeet.config.JwtTokenUtil;
import com.gksj.allaboutfeet.entity.User;
import com.gksj.allaboutfeet.models.JwtRequest;
import com.gksj.allaboutfeet.models.JwtResponse;
import com.gksj.allaboutfeet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserService userService;

  @PostMapping(path = "/login")
  public ResponseEntity<JwtResponse> createAuthenticationToken(
      @RequestBody JwtRequest authenticationRequest) throws Exception {
    Boolean result = userService
        .authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    if (result) {
      User userDetails = userService.getByUsername(authenticationRequest.getUsername());
      final String token = jwtTokenUtil.generateToken(userDetails);
      return ResponseEntity.ok(new JwtResponse(token));
    }
    return new ResponseEntity<>(new JwtResponse(""), HttpStatus.UNAUTHORIZED);

  }

  @PostMapping(path = "/signup")
  public ResponseEntity<JwtResponse> createUserAndAuthtenticationToken(@RequestBody User user) {
    userService.createUser(user);
    final String token = jwtTokenUtil.generateToken(user);
    return ResponseEntity.ok(new JwtResponse(token));
  }

  @PostMapping(path = "/currentuser")
  public ResponseEntity<JwtResponse> currentUser(@RequestHeader String token) {
    final String user = jwtTokenUtil.getUsernameFromToken(token);
    return ResponseEntity.ok(new JwtResponse(token));
  }

}
