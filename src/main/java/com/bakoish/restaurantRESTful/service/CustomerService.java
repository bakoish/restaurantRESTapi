package com.bakoish.restaurantRESTful.service;

import com.bakoish.restaurantRESTful.model.Customer;
import com.bakoish.restaurantRESTful.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Transactional
    public Customer getCustomerById(Long id) {
        return customerRepository.getById(id);
    }

    @Transactional
    public Customer postSingleCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer putSingleCustomer(Customer customer, Long id) {
        Customer tmpCustomer = customerRepository.findById(id).orElseThrow();
        tmpCustomer.setName(customer.getName());
        tmpCustomer.setSurname(customer.getSurname());
        tmpCustomer.setAddress(tmpCustomer.getAddress());
        return customerRepository.save(customer);
    }
}
