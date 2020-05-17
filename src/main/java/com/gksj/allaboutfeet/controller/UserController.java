package com.gksj.allaboutfeet.controller;
//import com.gksj.allaboutfeet.config.JwtTokenUtil;

import com.gksj.allaboutfeet.config.JwtTokenUtil;
import com.gksj.allaboutfeet.entity.Cart;
import com.gksj.allaboutfeet.entity.Products;
import com.gksj.allaboutfeet.entity.User;
import com.gksj.allaboutfeet.models.AddToCartReq;
import com.gksj.allaboutfeet.models.AddToCartRes;
import com.gksj.allaboutfeet.models.CurrentUser;
import com.gksj.allaboutfeet.models.JwtRequest;
import com.gksj.allaboutfeet.models.JwtResponse;
import com.gksj.allaboutfeet.services.CartService;
import com.gksj.allaboutfeet.services.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  @Autowired
  private CartService cartService;

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
    if (userService.alreadyExists(user.getUsername())) {
      return new ResponseEntity<>(new JwtResponse(""), HttpStatus.BAD_REQUEST);
    }
    userService.createUser(user);
    final String token = jwtTokenUtil.generateToken(user);
    return ResponseEntity.ok(new JwtResponse(token));
  }

  @GetMapping(path = "/current-user")
  public ResponseEntity<CurrentUser> currentUser(@RequestHeader String Authorization) {
    CurrentUser currentUser = new CurrentUser();
    String user = getUserFromHeader(Authorization);
    currentUser.setUsername(user);
    currentUser.setCart(cartService.cartValue(user));
    return ResponseEntity.ok(currentUser);
  }

  @PostMapping(path = "/add-to-cart")
  public AddToCartRes addToCart(@RequestBody AddToCartReq cart,
      @RequestHeader String Authorization) {
    Cart context = new Cart();
    context.setUsername(getUserFromHeader(Authorization));
    context.setPid(cart.getPid());
    context.setQuantity(cart.getQuantity());
    context.setSize(cart.getSize());
    cartService.addToCart(context);
    AddToCartRes addToCartRes = new AddToCartRes();
    addToCartRes.setCreated("true");
    return addToCartRes;
  }

  @GetMapping(path = "/cart")
  public ArrayList<Products> getCart(@RequestHeader String Authorization) {
    String user = getUserFromHeader(Authorization);
    return cartService.getItems(user);
  }

  private String getUserFromHeader(String token) {
    return jwtTokenUtil.getUsernameFromToken(token.substring(7));
  }

}
