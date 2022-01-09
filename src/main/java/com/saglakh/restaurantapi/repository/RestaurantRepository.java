package com.saglakh.restaurantapi.repository;

import com.saglakh.restaurantapi.repository.entity.RestaurantEntity;
import java.util.List;

public class RestaurantRepository {

  public RestaurantRepository() {

  }

  public List<RestaurantEntity> getAll() {
    return List.of(new RestaurantEntity().setId("1")
        .setName("80 Grados")
        .setDescription("Restaurante 80 grados en malasaña")
        .setCity("Madrid")
        .setAddress("Manuela malasaña 1")
        .setRating("10")
        .setComment("Favourite restaurant"));
  }

}
