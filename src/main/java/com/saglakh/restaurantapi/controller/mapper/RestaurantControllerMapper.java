package com.saglakh.restaurantapi.controller.mapper;

import com.saglakh.restaurantapi.controller.dto.RestaurantDto;
import com.saglakh.restaurantapi.service.model.Restaurant;
import java.util.List;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = "spring")
public interface RestaurantControllerMapper {

  List<RestaurantDto> toDtoArray(List<Restaurant> restaurants);

}
