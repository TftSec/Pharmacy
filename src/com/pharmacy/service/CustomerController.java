package com.pharmacy.service;

import com.pharmacy.model.Customer;
import com.pharmacy.service.CustomerService;
import java.util.List;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Customer getCustomerById(String id) {
        return customerService.getCustomerById(id);
    }

    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    public void removeCustomer(String id) {
        customerService.removeCustomer(id);
    }
}