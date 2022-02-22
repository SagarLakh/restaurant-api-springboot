package com.saglakh.restaurantapi.controller;

import com.saglakh.restaurantapi.controller.dto.RestaurantDto;
import com.saglakh.restaurantapi.controller.mapper.RestaurantControllerMapper;
import com.saglakh.restaurantapi.service.RestaurantService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestaurantController {

  private final RestaurantService restaurantService;
  private final RestaurantControllerMapper restaurantMapper;

  public RestaurantController(final RestaurantService restaurantService, final RestaurantControllerMapper restaurantMapper) {
    this.restaurantService = restaurantService;
    this.restaurantMapper = restaurantMapper;
  }

  @GetMapping("/restaurant")
  public List<RestaurantDto> getRestaurants() {
    return restaurantMapper.toDtoArray(restaurantService.getAll());
  }

}
