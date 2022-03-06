package com.saglakh.restaurantapi.service.config;

import com.saglakh.restaurantapi.repository.RestaurantRepository;
import com.saglakh.restaurantapi.service.RestaurantService;
import com.saglakh.restaurantapi.service.RestaurantServiceImpl;
import com.saglakh.restaurantapi.service.mapper.RestaurantServiceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EnableJpaRepositories("com.saglakh.restaurantapi")
public class ServiceConfiguration {

  @Bean
  public RestaurantService getRestaurantService(final RestaurantRepository restaurantRepository, final RestaurantServiceMapper restaurantServiceMapper) {
    return new RestaurantServiceImpl(restaurantRepository, restaurantServiceMapper);
  }

}
