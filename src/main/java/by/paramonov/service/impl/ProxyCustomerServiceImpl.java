package by.paramonov.service.impl;

import by.paramonov.cache.Cache;
import by.paramonov.dao.Dao;
import by.paramonov.entity.Customer;
import by.paramonov.factory.CacheFactory;
import by.paramonov.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProxyCustomerServiceImpl implements CustomerService {
    private final Cache<Long, Customer> customerCache;
    private final CustomerService customerService = new CustomerServiceImpl();

    public ProxyCustomerServiceImpl(CacheFactory<Long, Customer> customerCacheFactory) {
        this.customerCache = customerCacheFactory.createCache();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
        customerCache.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
        customerCache.remove(customerId);
    }

    @Override
    public Customer getById(Long customerId) {
        if (customerCache.contains(customerId)) {
            return customerCache.get(customerId);
        } else {
            return customerService.getById(customerId);
        }
    }

    @Override
    public void update(Customer customer) {
        customerService.update(customer);
        customerCache.put(customer.getId(), customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerService.getAll();
    }
}
