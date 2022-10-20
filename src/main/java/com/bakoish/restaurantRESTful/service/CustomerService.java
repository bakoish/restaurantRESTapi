package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Address;
import com.bakoish.restaurantRESTful.model.Customer;
import com.bakoish.restaurantRESTful.model.dto.CustomerDto;
import com.bakoish.restaurantRESTful.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerFactory customerFactory;

    public CustomerService(CustomerRepository customerRepository, CustomerFactory customerFactory) {
        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Transactional
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Customer postSingleCustomer(CustomerDto customerDto) {
        customerDto.validate();
        Customer customer = customerFactory.create(customerDto);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer putSingleCustomer(CustomerDto customerDto, Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow();
        customerDto.validate();
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setAddress(new Address(customerDto.getAddressDto().getAddress(),customerDto.getAddressDto().getPostCode(),customerDto.getAddressDto().getCountry(),customerDto.getAddressDto().getPhoneNumber()));
        return customerRepository.save(customer);
    }
}
