package com.bakoish.restaurantRESTful.config;


import com.bakoish.restaurantRESTful.model.Address;
import com.bakoish.restaurantRESTful.model.Customer;
import com.bakoish.restaurantRESTful.model.Dish;
import com.bakoish.restaurantRESTful.repository.CustomerRepository;
import com.bakoish.restaurantRESTful.repository.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
class LoadDatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseConfig.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, DishRepository dishRepository) {

        return args -> {
            log.info("Preloading " + customerRepository.save(new Customer("Adam","Nowak", new Address("Kolorowa 2/12","30-481","Poland","123456789"))));
            log.info("Preloading " + dishRepository.save(new Dish("Ice cream","Strawberry ice cream", new BigDecimal("10.0"))));
        };
    }
}
