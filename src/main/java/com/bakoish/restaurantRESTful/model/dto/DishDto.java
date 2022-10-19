package com.bakoish.restaurantRESTful.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class DishDto {

    private String name;
    private String description;
    private BigDecimal price;

    public void validate() {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value name can't be empty!" );
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Description can't be empty!");
        }
        if (price == null) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Price can't be empty!" );
        } else if(price.doubleValue() <= 0) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Price can't be less or equal 0!" );
        }

    }
}
