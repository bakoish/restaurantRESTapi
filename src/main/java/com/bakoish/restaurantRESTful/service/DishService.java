package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Dish;
import com.bakoish.restaurantRESTful.model.dto.DishDto;
import com.bakoish.restaurantRESTful.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    DishRepository dishRepository;
    DishFactory dishFactory;
    public DishService(DishRepository dishRepository, DishFactory dishFactory) {
        this.dishRepository = dishRepository;
        this.dishFactory = dishFactory;
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish getDishById(Long dishId) {
        return dishRepository.findById(dishId).orElseThrow();
    }

    public Dish postSingleDish(DishDto dishDto) {
        dishDto.validate();
        Dish dish = dishFactory.create(dishDto);
        return dishRepository.save(dish);
    }

    public Dish putSingleDish(DishDto dishDto, Long Id) {
        Dish dish = dishRepository.findById(Id).orElseThrow();
        dishDto.validate();
        dish.setName(dishDto.getName());
        dish.setDescription(dishDto.getDescription());
        dish.setPrice(dishDto.getPrice());
        return dishRepository.save(dish);
    }
}
