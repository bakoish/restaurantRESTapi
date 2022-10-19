package com.bakoish.restaurantRESTful.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    private String address;
    private String postCode;
    private String country;
    private String phoneNumber;

    public void validate() {

        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value address can't be empty!");
        }
        if (postCode == null || postCode.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value post code can't be empty!");
        } else if (!postCode.matches("[0-9]{2}-[0-9]{3}")) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Not supported post code format!");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value country can't be empty!");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Value phone number can't be empty!");
        } else if(!phoneNumber.matches("(^[1-9]\\d{8}$)")) {
            throw new IllegalArgumentException(this.getClass().getName() + " - Not supported phone number format - Only 9 numbers!");
        }

    }
}
