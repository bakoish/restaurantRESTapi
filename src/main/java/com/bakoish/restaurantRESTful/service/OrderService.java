package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Order;
import com.bakoish.restaurantRESTful.model.dto.OrderDto;
import com.bakoish.restaurantRESTful.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    OrderFactory orderFactory;
    CustomerFactory customerFactory;
    DishFactory dishFactory;

    public OrderService(OrderRepository orderRepository, OrderFactory orderFactory, CustomerFactory customerFactory, DishFactory dishFactory) {
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
        this.customerFactory = customerFactory;
        this.dishFactory = dishFactory;
    }

    public List<Order> getAllDishes() {
        return orderRepository.findAll();
    }

    public Order getDishById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    public Order postSingleDish(OrderDto orderDto) {
        orderDto.validate();
        Order order = orderFactory.create(orderDto);
        return orderRepository.save(order);
    }

    public Order putSingleDish(OrderDto orderDto, Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        orderDto.validate();
        order.setOrderDate(orderDto.getOrderDate());
        order.setCustomer(customerFactory.create(orderDto.getCustomer()));
        order.setDishes(dishFactory.createList(orderDto.getDishes()));
        return orderRepository.save(order);
    }
}
