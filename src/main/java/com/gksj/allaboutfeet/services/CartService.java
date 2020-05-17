package com.gksj.allaboutfeet.services;

import com.gksj.allaboutfeet.entity.Cart;
import com.gksj.allaboutfeet.entity.Products;
import com.gksj.allaboutfeet.repository.CartRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  @Autowired
  CartRepository cartRepository;

  public Integer cartValue(String name) {
    return cartRepository.cartQuantity(name);
  }

  public void addToCart(Cart cart) {
    cart.setId((int) (cartRepository.count()+1));
    cartRepository.save(cart);
  }

  public ArrayList<Products> getItems(String name) {
    return cartRepository.cartItems(name);
  }

}
