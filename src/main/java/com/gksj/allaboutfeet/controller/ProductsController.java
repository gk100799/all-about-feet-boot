package com.gksj.allaboutfeet.controller;

import com.gksj.allaboutfeet.entity.Products;
import com.gksj.allaboutfeet.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping(path="/", produces = "application/json")
    public List<Products> getProducts() {
        return productsService.allProducts();
    }

    @GetMapping(path = "/{pid}", produces = "application/json")
    public ResponseEntity<Optional<Products>>  getProduct(@PathVariable("pid") Integer pid) {
        return new ResponseEntity<>(
                productsService.getProduct(pid), HttpStatus.OK);
    }

}
