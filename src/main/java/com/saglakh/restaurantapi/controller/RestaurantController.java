package com.saglakh.restaurantapi.controller;

import com.saglakh.restaurantapi.controller.mapper.RestaurantControllerMapper;
import com.saglakh.restaurantapi.rest.api.RestaurantsApi;
import com.saglakh.restaurantapi.rest.model.RestaurantDto;
import com.saglakh.restaurantapi.service.RestaurantService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestaurantController implements RestaurantsApi {

  private final RestaurantService restaurantService;
  private final RestaurantControllerMapper restaurantMapper;

  public RestaurantController(final RestaurantService restaurantService, final RestaurantControllerMapper restaurantMapper) {
    this.restaurantService = restaurantService;
    this.restaurantMapper = restaurantMapper;
  }

  @Override
  public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
    return ResponseEntity.ok(restaurantMapper.toDtoArray(restaurantService.getAll()));
  }

}
