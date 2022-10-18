package com.bakoish.restaurantRESTful.repository;

import com.bakoish.restaurantRESTful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}