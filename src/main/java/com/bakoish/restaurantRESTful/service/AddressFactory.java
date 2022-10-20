package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Address;
import com.bakoish.restaurantRESTful.model.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressFactory {
    public AddressFactory() {
    }
    public Address create(AddressDto addressDto) {
        return new Address(addressDto.getAddress(), addressDto.getPostCode(), addressDto.getCountry(), addressDto.getPostCode());
    }
}

