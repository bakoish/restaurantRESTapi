package com.bakoish.restaurantRESTful.repository;

import com.bakoish.restaurantRESTful.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}