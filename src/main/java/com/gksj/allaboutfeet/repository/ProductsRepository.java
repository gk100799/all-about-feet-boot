package com.gksj.allaboutfeet.repository;

import com.gksj.allaboutfeet.entity.Products;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

  @Query("SELECT p FROM Products p WHERE pid IN (SELECT s.pid FROM ProductSubs s WHERE s.bname IN :brands AND s.sname IN :styles AND s.cname IN :colors)")
  public ArrayList<Products> filterProducts(ArrayList<String> brands,  ArrayList<String> styles,
       ArrayList<String> colors);
}
