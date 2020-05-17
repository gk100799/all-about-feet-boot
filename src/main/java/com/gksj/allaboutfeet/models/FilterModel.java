package com.gksj.allaboutfeet.models;

import java.util.ArrayList;
import lombok.Data;

@Data
public class FilterModel {
  private ArrayList<String> brands;
  private ArrayList<String> styles;
  private ArrayList<String> colors;
}
