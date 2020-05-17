package com.gksj.allaboutfeet.models;

import lombok.Data;

@Data
public class AddToCartReq {
  private Integer pid;
  private Integer quantity;
  private Integer size;
}
