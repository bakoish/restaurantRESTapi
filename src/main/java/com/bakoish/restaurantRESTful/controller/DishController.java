package com.bakoish.restaurantRESTful.controller;

import com.bakoish.restaurantRESTful.model.Customer;
import com.bakoish.restaurantRESTful.model.Dish;
import com.bakoish.restaurantRESTful.model.dto.CustomerDto;
import com.bakoish.restaurantRESTful.model.dto.DishDto;
import com.bakoish.restaurantRESTful.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/")
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{dishId}")
    public Dish getDishById(@PathVariable("dishId") Long dishId) {
        return dishService.getDishById(dishId);
    }

    @PostMapping("/")
    public Dish postDish(@RequestBody DishDto dishDto) {
        return dishService.postSingleDish(dishDto);
    }

    @PutMapping("/{dishId}")
    public Dish putCustomer(@RequestBody DishDto dishDto, @PathVariable("dishId") Long dishId) {
        return dishService.putSingleDish(dishDto, dishId);
    }

}
