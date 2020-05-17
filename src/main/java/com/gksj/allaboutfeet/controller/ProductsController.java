package com.gksj.allaboutfeet.controller;

import com.gksj.allaboutfeet.entity.Products;
import com.gksj.allaboutfeet.models.FilterModel;
import com.gksj.allaboutfeet.services.ProductsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductsController {

  @Autowired
  private ProductsService productsService;

  @GetMapping(path = "/", produces = "application/json")
  public List<Products> getProducts() {
    return productsService.allProducts();
  }

  @GetMapping(path = "/{pid}", produces = "application/json")
  public ResponseEntity<Optional<Products>> getProduct(@PathVariable("pid") Integer pid) {
    return new ResponseEntity<>(
        productsService.getProduct(pid), HttpStatus.OK);
  }

  @PostMapping(path = "/filter", produces = "application/json")
  public List<Products> filteredProducts(@RequestBody FilterModel filterModel) {
    return productsService.filteredProducts(filterModel.getBrands(), filterModel.getStyles(), filterModel.getColors());
  }

}
