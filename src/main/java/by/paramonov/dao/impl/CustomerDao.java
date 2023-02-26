package by.paramonov.dao.impl;

import by.paramonov.dao.Dao;
import by.paramonov.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomerDao implements Dao<Customer> {

    private Map<Long, Customer> customerMap;

    public CustomerDao() {
        customerMap = new HashMap<>();
    }

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
    public void delete(Long customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerMap.values());
    }
}
