package com.saglakh.restaurantapi.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RestaurantEntity {

  private String id;

  private String name;

  private String description;

  private String city;

  private String address;

  private String rating;

  private String comment;

}
