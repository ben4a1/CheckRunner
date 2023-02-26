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
    private final Dao<Customer> customerDao;
    private final Cache<Long, Customer> customerCache;
    private final CustomerService customerService = new CustomerServiceImpl();

    public ProxyCustomerServiceImpl(Dao<Customer> customerDao, CacheFactory<Long, Customer> customerCacheFactory) {
        this.customerDao = customerDao;
        this.customerCache = customerCacheFactory.createCache();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
//        customerCache.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
//        customerDao.delete(customerId);
//        customerCache.remove(customerId);
    }

    @Override
    public Customer getById(Long customerId) {
        return customerService.getById(customerId);
//        return customerCache.contains(customerId)
//                ? customerCache.get(customerId)
//                : customerDao.read(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerService.update(customer);
//        customerDao.update(customer);
//        customerCache.put(customer.getId(), customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerService.getAll();
//        return customerDao.getAll();
    }
}
