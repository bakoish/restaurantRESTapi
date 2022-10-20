package com.bakoish.restaurantRESTful.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private String name;
    private String surname;
    private AddressDto addressDto;

    public void validate() {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value name can't be empty!" );
        }
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value name can't be empty!");
        }

        addressDto.validate();

    }
}
