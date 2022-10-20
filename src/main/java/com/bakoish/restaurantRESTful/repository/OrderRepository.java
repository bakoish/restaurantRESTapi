package com.bakoish.restaurantRESTful.repository;

import com.bakoish.restaurantRESTful.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}