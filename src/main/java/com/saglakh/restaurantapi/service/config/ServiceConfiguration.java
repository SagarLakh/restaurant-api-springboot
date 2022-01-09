package com.saglakh.restaurantapi.service.config;

import com.saglakh.restaurantapi.repository.RestaurantRepository;
import com.saglakh.restaurantapi.service.RestaurantService;
import com.saglakh.restaurantapi.service.RestaurantServiceImpl;
import com.saglakh.restaurantapi.service.mapper.RestaurantServiceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

  @Bean
  public RestaurantService getRestaurantService(final RestaurantRepository restaurantRepository, final RestaurantServiceMapper restaurantServiceMapper) {
    return new RestaurantServiceImpl(restaurantRepository, restaurantServiceMapper);
  }

  @Bean
  public RestaurantRepository getRestaurantRepository() {
    return new RestaurantRepository();
  }

}
