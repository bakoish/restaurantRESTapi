package com.bakoish.restaurantRESTful.controller;

import com.bakoish.restaurantRESTful.model.Customer;
import com.bakoish.restaurantRESTful.model.dto.CustomerDto;
import com.bakoish.restaurantRESTful.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/")
    public Customer postCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.postSingleCustomer(customerDto);
    }

    @PutMapping("/{customerId}")
    public Customer putCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId) {
        return customerService.putSingleCustomer(customerDto, customerId);
    }
}
