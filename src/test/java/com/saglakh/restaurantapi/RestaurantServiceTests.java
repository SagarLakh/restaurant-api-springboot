package com.saglakh.restaurantapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.saglakh.restaurantapi.repository.RestaurantRepository;
import com.saglakh.restaurantapi.repository.entity.RestaurantEntity;
import com.saglakh.restaurantapi.rest.model.RestaurantDto;
import com.saglakh.restaurantapi.service.RestaurantService;
import com.saglakh.restaurantapi.service.RestaurantServiceImpl;
import com.saglakh.restaurantapi.service.mapper.RestaurantServiceMapperImpl;
import com.saglakh.restaurantapi.service.model.OperationResult;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;

public class RestaurantServiceTests {

  private static RestaurantService restaurantService;

  private static RestaurantRepository restaurantRepository;

  @BeforeAll
  static void setUp() {
    restaurantRepository = Mockito.mock(RestaurantRepository.class);
    restaurantService = new RestaurantServiceImpl(restaurantRepository, new RestaurantServiceMapperImpl());
  }

  @Test
  void getById_Ok() {
    RestaurantEntity restaurantEntity = new RestaurantEntity()
        .setId(1L).setAddress("address").setCity("city").setDescription("description").setName("name");
    Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurantEntity));

    Optional<RestaurantDto> restaurantDtoOptional = restaurantService.getById(1L);
    RestaurantDto restaurantDto = new RestaurantDto()
        .id(1L).address("address").city("city").description("description").name("name");

    assertThat(restaurantDtoOptional).contains(restaurantDto);
  }

  @Test
  void getById_Empty() {
    Mockito.when(restaurantRepository.findById(2L)).thenReturn(Optional.empty());

    Optional<RestaurantDto> restaurantDtoOptional = restaurantService.getById(2L);

    assertThat(restaurantDtoOptional).isEmpty();
  }

  @Test
  void create_Ok() {
    Mockito.when(restaurantRepository.findById(3L)).thenReturn(Optional.empty());

    RestaurantDto restaurantDto = new RestaurantDto()
        .id(3L).name("name").description("description").city("city").address("address");
    OperationResult result = restaurantService.create(restaurantDto);

    assertThat(result).isEqualTo(OperationResult.OK);
  }

  @Test
  void create_Conflict() {
    RestaurantEntity restaurantEntity = new RestaurantEntity()
        .setId(4L).setName("name").setDescription("description").setCity("city").setAddress("address");
    Mockito.when(restaurantRepository.findById(4L)).thenReturn(Optional.of(restaurantEntity));

    RestaurantDto restaurantDto = new RestaurantDto()
        .id(4L).name("name").description("description").city("city").address("address");
    OperationResult result = restaurantService.create(restaurantDto);

    assertThat(result).isEqualTo(OperationResult.CONFLICT);
  }

  @Test
  void create_Error() {
    Mockito.when(restaurantRepository.findById(5L)).thenThrow(new DataIntegrityViolationException("fail test"));

    RestaurantDto restaurantDto = new RestaurantDto()
        .id(5L).name("name").description("description").city("city").address("address");
    OperationResult result = restaurantService.create(restaurantDto);

    assertThat(result).isEqualTo(OperationResult.ERROR);
  }

  @Test
  void update_Ok() {
    RestaurantEntity restaurantEntity = new RestaurantEntity()
        .setId(6L).setName("name").setDescription("description").setCity("city").setAddress("address");
    Mockito.when(restaurantRepository.findById(6L)).thenReturn(Optional.of(restaurantEntity));

    RestaurantDto restaurantDto = new RestaurantDto()
        .id(6L).name("name2").description("description2").city("city2").address("address2");
    OperationResult result = restaurantService.updateById(restaurantDto);

    assertThat(result).isEqualTo(OperationResult.OK);
  }

  @Test
  void update_NotFound() {
    Mockito.when(restaurantRepository.findById(7L)).thenReturn(Optional.empty());

    RestaurantDto restaurantDto = new RestaurantDto()
        .id(7L).name("name").description("description").city("city").address("address");
    OperationResult result = restaurantService.updateById(restaurantDto);

    assertThat(result).isEqualTo(OperationResult.NOT_FOUND);
  }

  @Test
  void update_Error() {
    Mockito.when(restaurantRepository.findById(8L)).thenThrow(new DataIntegrityViolationException("fail test"));

    RestaurantDto restaurantDto = new RestaurantDto()
        .id(8L).name("name").description("description").city("city").address("address");
    OperationResult result = restaurantService.updateById(restaurantDto);

    assertThat(result).isEqualTo(OperationResult.ERROR);
  }

  @Test
  void delete_Ok() {
    RestaurantEntity restaurantEntity = new RestaurantEntity()
        .setId(9L).setName("name").setDescription("description").setCity("city").setAddress("address");
    Mockito.when(restaurantRepository.findById(9L)).thenReturn(Optional.of(restaurantEntity));

    OperationResult result = restaurantService.deleteById(9L);

    assertThat(result).isEqualTo(OperationResult.OK);
  }

  @Test
  void delete_NotFound() {
    Mockito.when(restaurantRepository.findById(10L)).thenReturn(Optional.empty());

    OperationResult result = restaurantService.deleteById(10L);

    assertThat(result).isEqualTo(OperationResult.NOT_FOUND);
  }

  @Test
  void delete_Error() {
    Mockito.when(restaurantRepository.findById(11L)).thenThrow(new DataIntegrityViolationException("fail test"));

    OperationResult result = restaurantService.deleteById(11L);

    assertThat(result).isEqualTo(OperationResult.ERROR);
  }

  @Test
  void getAll_OK() {
    RestaurantEntity restaurantEntity1 = new RestaurantEntity().setId(12L);
    RestaurantEntity restaurantEntity2 = new RestaurantEntity().setId(13L);
    Mockito.when(restaurantRepository.findAll()).thenReturn(List.of(restaurantEntity1, restaurantEntity2));

    List<RestaurantDto> restaurants = restaurantService.getAll();
    RestaurantDto restaurantDto1 = new RestaurantDto().id(12L);
    RestaurantDto restaurantDto2 = new RestaurantDto().id(13L);

    assertThat(restaurants).hasSize(2).containsExactly(restaurantDto1, restaurantDto2);
  }

  @Test
  void getAll_Empty() {
    Mockito.when(restaurantRepository.findAll()).thenReturn(List.of());

    List<RestaurantDto> restaurants = restaurantService.getAll();

    assertThat(restaurants).isEmpty();
  }

}
