package com.pharmacy.service;

import com.pharmacy.model.Customer;
import com.pharmacy.repository.CustomerRepository;
import com.pharmacy.repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceTest {
    public static void main(String[] args) {
        // Use the real (in-memory) repository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerServiceImpl(repository);

        // Test adding customers
        Customer c1 = new Customer("Alice", "Smith", "0123456789");
        Customer c2 = new Customer("Bob", "Jones", "0987654321");

        service.addCustomer(c1);
        service.addCustomer(c2);

        // Test getAllCustomers
        List<Customer> customers = service.getAllCustomers();
        System.out.println("All customers: " + customers);

        // Test getCustomerById
        Customer found = service.getCustomerById(c1.getId());
        System.out.println("Found customer: " + found);

        // Test updateCustomer
        c1.setLastName("Johnson");
        service.updateCustomer(c1);
        System.out.println("Updated customer: " + service.getCustomerById(c1.getId()));

        // Test removeCustomer
        service.removeCustomer(c2.getId());
        System.out.println("All customers after removal: " + service.getAllCustomers());
    }
}