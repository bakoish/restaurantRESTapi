package com.bakoish.restaurantRESTful.controller;

import com.bakoish.restaurantRESTful.model.Dish;
import com.bakoish.restaurantRESTful.model.Order;
import com.bakoish.restaurantRESTful.model.dto.DishDto;
import com.bakoish.restaurantRESTful.model.dto.OrderDto;
import com.bakoish.restaurantRESTful.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllDishes();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable("orderId") Long orderId) {
        return orderService.getDishById(orderId);
    }

    @PostMapping("/")
    public Order postOrder(@RequestBody OrderDto orderDto) {
        return orderService.postSingleDish(orderDto);
    }

    @PutMapping("/{orderId}")
    public Order putOrder(@RequestBody OrderDto orderDto, @PathVariable("orderId") Long dishId) {
        return orderService.putSingleDish(orderDto, dishId);
    }

}
