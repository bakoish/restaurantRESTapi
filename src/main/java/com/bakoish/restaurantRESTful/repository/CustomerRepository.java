package com.bakoish.restaurantRESTful.repository;

import com.bakoish.restaurantRESTful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("Select c From Customer c" +
            " join fetch c.address")
    List<Customer> findAllCustomers();
}