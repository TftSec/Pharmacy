package com.pharmacy.service;

import com.pharmacy.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer getCustomerById(String id);
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void removeCustomer(String id);
}