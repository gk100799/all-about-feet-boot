package com.gksj.allaboutfeet.controller;

import java.util.List;

import com.gksj.allaboutfeet.entity.Brands;
import com.gksj.allaboutfeet.services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/brands")
public class BrandsController {
    @Autowired
    private BrandsService brandsService;

    @GetMapping(path="/", produces = "application/json")
    public List<Brands> allBrands()
    {
        return brandsService.allBrands();
    }

    @GetMapping(path="/hello")
    public String hello() {
        return "hello";
    }
}
