package com.gksj.allaboutfeet.services;

import com.gksj.allaboutfeet.entity.Products;
import com.gksj.allaboutfeet.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public List<Products> allProducts() {
        List<Products> list = new ArrayList<>();
        productsRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Optional<Products> getProduct(Integer pid) {
        return productsRepository.findById(pid);
    }

}
