package by.paramonov.cache.dao.impl;

import by.paramonov.cache.dao.Dao;
import by.paramonov.entity.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDao implements Dao<Customer> {

    private Map<Long, Customer> customerMap = new HashMap<>();
    @Override
    public void create(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer read(long id) {
        return customerMap.get(id);
    }

    @Override
    public void update(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public void delete(Customer customer) {
    customerMap.remove(customer.getId());
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerMap.values());
    }
}
