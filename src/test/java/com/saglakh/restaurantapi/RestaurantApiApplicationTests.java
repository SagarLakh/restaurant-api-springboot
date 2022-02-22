package com.saglakh.restaurantapi;

import com.saglakh.restaurantapi.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {RestaurantRepository.class})
@EnableAutoConfiguration
@ActiveProfiles("test")
class RestaurantApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
