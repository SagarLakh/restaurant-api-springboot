package com.saglakh.restaurantapi.service.mapper;

import com.saglakh.restaurantapi.repository.entity.RestaurantEntity;
import com.saglakh.restaurantapi.rest.model.RestaurantDto;
import java.util.List;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = "spring")
public interface RestaurantServiceMapper {

  List<RestaurantDto> toListDto(List<RestaurantEntity> restaurants);

  RestaurantDto toDto(RestaurantEntity restaurant);

  RestaurantEntity toEntity(RestaurantDto restaurant);

}
