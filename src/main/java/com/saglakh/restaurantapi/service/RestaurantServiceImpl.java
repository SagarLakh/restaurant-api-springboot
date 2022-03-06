package com.saglakh.restaurantapi.service;

import com.saglakh.restaurantapi.repository.RestaurantRepository;
import com.saglakh.restaurantapi.repository.entity.RestaurantEntity;
import com.saglakh.restaurantapi.rest.model.RestaurantDto;
import com.saglakh.restaurantapi.service.mapper.RestaurantServiceMapper;
import com.saglakh.restaurantapi.service.model.OperationResult;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final RestaurantServiceMapper restaurantServiceMapper;

  public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantServiceMapper restaurantServiceMapper) {
    this.restaurantRepository = restaurantRepository;
    this.restaurantServiceMapper = restaurantServiceMapper;
  }

  @Override
  public List<RestaurantDto> getAll() {
    return restaurantServiceMapper.toListDto(restaurantRepository.findAll());
  }

  @Override
  public Optional<RestaurantDto> getById(Long id) {
    return restaurantRepository.findById(id).map(restaurantServiceMapper::toDto);
  }

  @Override
  public OperationResult create(RestaurantDto restaurantDto) {
    try {
      Optional<RestaurantEntity> restaurantOp = restaurantRepository.findById(restaurantDto.getId());
      if (restaurantOp.isPresent()) {
        return OperationResult.CONFLICT;
      }
      restaurantRepository.save(restaurantServiceMapper.toEntity(restaurantDto));
    }
    catch (DataAccessException e) {
      log.error(String.format("Error creating restaurant entity with id [%s] ", restaurantDto.getId()), e);
      return OperationResult.ERROR;
    }
    return OperationResult.OK;
  }

  @Override
  public OperationResult updateById(RestaurantDto restaurantDto) {
    try {
      Optional<RestaurantEntity> restaurantOp = restaurantRepository.findById(restaurantDto.getId());
      if (restaurantOp.isEmpty()) {
        return OperationResult.NOT_FOUND;
      }
      restaurantRepository.save(restaurantServiceMapper.toEntity(restaurantDto));
    }
    catch (DataAccessException e) {
      log.error(String.format("Error updating restaurant entity with id [%s] ", restaurantDto.getId()), e);
      return OperationResult.ERROR;
    }
    return OperationResult.OK;
  }

  @Override
  public OperationResult deleteById(Long id) {
    try {
      Optional<RestaurantEntity> restaurantOp = restaurantRepository.findById(id);
      if (restaurantOp.isEmpty()) {
        return OperationResult.NOT_FOUND;
      }
      restaurantRepository.deleteById(id);
    }
    catch (DataAccessException e) {
      log.error(String.format("Error deleting restaurant entity with id [%s] ", id), e);
      return OperationResult.ERROR;
    }
    return OperationResult.OK;
  }
}
