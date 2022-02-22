package com.saglakh.restaurantapi.service;

import com.saglakh.restaurantapi.repository.RestaurantRepository;
import com.saglakh.restaurantapi.service.mapper.RestaurantServiceMapper;
import com.saglakh.restaurantapi.service.model.Restaurant;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final RestaurantServiceMapper restaurantServiceMapper;

  public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantServiceMapper restaurantServiceMapper) {
    this.restaurantRepository = restaurantRepository;
    this.restaurantServiceMapper = restaurantServiceMapper;
  }

  public List<Restaurant> getAll() {
    return restaurantServiceMapper.toListModel(restaurantRepository.findAll());
  }

}
