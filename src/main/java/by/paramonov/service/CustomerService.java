package by.paramonov.service;

import by.paramonov.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    Customer getById(long customerId);
    void update(Customer customer);
    List<Customer> getAll();
}
