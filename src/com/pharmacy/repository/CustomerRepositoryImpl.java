package com.pharmacy.repository;

import com.pharmacy.model.Customer;
import java.util.ArrayList;
import java.util.List;

// Example in-memory implementation, replace with DB code
public class CustomerRepositoryImpl implements CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer findById(String id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void update(Customer customer) {
        delete(customer.getId());
        save(customer);
    }

    @Override
    public void delete(String id) {
        customers.removeIf(c -> c.getId().equals(id));
    }
}