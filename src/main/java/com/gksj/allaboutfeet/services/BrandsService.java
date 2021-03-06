package com.gksj.allaboutfeet.services;

import com.gksj.allaboutfeet.entity.Brands;
import com.gksj.allaboutfeet.repository.BrandsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandsService {

  @Autowired
  BrandsRepository brandsRepository;

  public List<Brands> allBrands() {
    List<Brands> list = new ArrayList<>();
    brandsRepository.findAll().forEach(e -> list.add(e));
    return list;
  }

}
