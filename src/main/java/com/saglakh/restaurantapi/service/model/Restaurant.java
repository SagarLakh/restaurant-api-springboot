package com.saglakh.restaurantapi.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Restaurant {

  private Long id;

  private String name;

  private String description;

  private String city;

  private String address;

}
