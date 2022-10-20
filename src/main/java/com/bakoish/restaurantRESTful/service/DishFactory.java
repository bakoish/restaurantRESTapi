package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Dish;
import com.bakoish.restaurantRESTful.model.dto.DishDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishFactory {

    public DishFactory() {}

    public Dish create(DishDto dishDto) {
        return new Dish(dishDto.getName(),dishDto.getDescription(),dishDto.getPrice());
    }

    public List<Dish> createList(List<DishDto> dishDtos) {
        List<Dish> dishes = new ArrayList<>();
        for (DishDto x: dishDtos) {
            dishes.add(new Dish(x.getName(), x.getDescription(), x.getPrice()));
        }
        return dishes;
    }

}
