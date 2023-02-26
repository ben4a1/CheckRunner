package by.paramonov.service.impl;

import by.paramonov.dao.Dao;
import by.paramonov.dao.impl.CustomerDao;
import by.paramonov.entity.Customer;
import by.paramonov.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Dao<Customer> customerDao;

    public CustomerServiceImpl() {
        this.customerDao = new CustomerDao();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.create(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerDao.delete(customerId);
    }

    @Override
    public Customer getById(Long customerId) {
        return customerDao.read(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
