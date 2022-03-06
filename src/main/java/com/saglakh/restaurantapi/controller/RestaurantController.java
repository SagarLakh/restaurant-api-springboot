package com.saglakh.restaurantapi.controller;

import com.saglakh.restaurantapi.rest.api.RestaurantsApi;
import com.saglakh.restaurantapi.rest.model.RestaurantDto;
import com.saglakh.restaurantapi.service.RestaurantService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestaurantController implements RestaurantsApi {

  private final RestaurantService restaurantService;

  public RestaurantController(final RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @Override
  public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
    return ResponseEntity.ok(restaurantService.getAll());
  }

  @Override
  public ResponseEntity<RestaurantDto> getRestaurantById(Long id) {
    return restaurantService.getById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Override
  public ResponseEntity<Void> updateRestaurantById(Long id, RestaurantDto restaurantDto) {
    return switch (restaurantService.updateById(restaurantDto)) {
      case OK -> new ResponseEntity<>(HttpStatus.OK);
      case NOT_FOUND -> new ResponseEntity<>(HttpStatus.NOT_FOUND);
      default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    };
  }

  @Override
  public ResponseEntity<Void> createRestaurant(RestaurantDto restaurantDto) {
    return switch (restaurantService.create(restaurantDto)) {
      case OK -> new ResponseEntity<>(HttpStatus.CREATED);
      case CONFLICT -> new ResponseEntity<>(HttpStatus.CONFLICT);
      default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    };
  }

  @Override
  public ResponseEntity<Void> deleteRestaurantById(Long id) {
    return switch (restaurantService.deleteById(id)) {
      case OK -> new ResponseEntity<>(HttpStatus.OK);
      case NOT_FOUND -> new ResponseEntity<>(HttpStatus.NOT_FOUND);
      default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    };
  }

}
