package com.pharmacy.repository;

import com.pharmacy.model.Customer;
import java.util.List;

public interface CustomerRepository {
    Customer findById(String id);
    List<Customer> findAll();
    void save(Customer customer);
    void update(Customer customer);
    void delete(String id);
}