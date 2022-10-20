package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Customer;
import com.bakoish.restaurantRESTful.model.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {
    AddressFactory addressFactory;

    public CustomerFactory(AddressFactory addressFactory) {
        this.addressFactory = addressFactory;
    }

    public Customer create(CustomerDto customerDto) {
        return new Customer(customerDto.getName(),customerDto.getSurname(),addressFactory.create(customerDto.getAddressDto()));
    }
}
