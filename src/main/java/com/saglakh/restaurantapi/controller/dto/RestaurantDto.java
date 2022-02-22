package com.saglakh.restaurantapi.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RestaurantDto {

  private Long id;

  private String name;

  private String description;

  private String city;

  private String address;


}
