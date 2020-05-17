package com.gksj.allaboutfeet.repository;

import com.gksj.allaboutfeet.entity.Cart;
import com.gksj.allaboutfeet.entity.Products;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

  @Query("SELECT count(*) FROM Cart WHERE username=:name")
  Integer cartQuantity(String name);

  @Query("SELECT p FROM Products p WHERE p.pid IN (SELECT c.pid FROM Cart c WHERE c.username=:name)")
  public ArrayList<Products> cartItems(String name);

}
