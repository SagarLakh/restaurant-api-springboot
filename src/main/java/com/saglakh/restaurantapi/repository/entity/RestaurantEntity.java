package com.saglakh.restaurantapi.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

  @Id
  private Long id;

  private String name;

  private String description;

  private String city;

  private String address;

}
