package com.saglakh.restaurantapi.service;

import com.saglakh.restaurantapi.rest.model.RestaurantDto;
import com.saglakh.restaurantapi.model.OperationResult;
import java.util.List;
import java.util.Optional;

public interface RestaurantService {

  List<RestaurantDto> getAll();

  Optional<RestaurantDto> getById(Long id);

  OperationResult create(RestaurantDto restaurant);

  OperationResult updateById(RestaurantDto restaurant);

  OperationResult deleteById(Long id);

}
