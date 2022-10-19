package com.bakoish.restaurantRESTful.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private LocalDate orderDate;

    private CustomerDto customer;

    private List<DishDto> dishes;

    public void validate() {

        if (orderDate == null) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Order date can't be empty!" );
        } else if(orderDate.isAfter(LocalDate.parse("2000-01-01")) && orderDate.isBefore(LocalDate.parse("2100-01-01"))) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Order date can't unreal!" );
        }

        customer.validate();

        for (DishDto oneDish: dishes ) {
            oneDish.validate();
        }

    }
}
