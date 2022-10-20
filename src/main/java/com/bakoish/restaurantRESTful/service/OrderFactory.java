package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Order;
import com.bakoish.restaurantRESTful.model.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    CustomerFactory customerFactory;
    DishFactory dishFactory;

    public OrderFactory(CustomerFactory customerFactory, DishFactory dishFactory) {
        this.customerFactory = customerFactory;
        this.dishFactory = dishFactory;
    }

    public Order create(OrderDto orderDto) {
        return new Order(orderDto.getOrderDate(),
                customerFactory.create(orderDto.getCustomer()),
                dishFactory.createList(orderDto.getDishes())
        );
    }
}
