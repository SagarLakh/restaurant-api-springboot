package com.saglakh.restaurantapi.repository;

import com.saglakh.restaurantapi.repository.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
