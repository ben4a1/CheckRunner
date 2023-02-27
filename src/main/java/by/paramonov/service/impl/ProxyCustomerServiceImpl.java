package by.paramonov.service.impl;

import by.paramonov.cache.Cache;
import by.paramonov.entity.Customer;
import by.paramonov.factory.CacheFactory;
import by.paramonov.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProxyCustomerServiceImpl implements CustomerService {
    private final Cache<Long, Customer> customerCache;
    private final CustomerService customerService = new CustomerServiceImpl();
    private final static Pattern PHONE_PATTERN = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");

    public ProxyCustomerServiceImpl(CacheFactory<Long, Customer> customerCacheFactory) {
        this.customerCache = customerCacheFactory.createCache();
    }

    @Override
    public void addCustomer(Customer customer) {
        if (isValidPhoneNumber(customer.getPhoneNumber())) {
            customerService.addCustomer(customer);
            customerCache.put(customer.getId(), customer);
        } else {
            throw new IllegalArgumentException("not valid phone number");
        }
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
        if (isValidPhoneNumber(customer.getPhoneNumber())) {
            customerService.update(customer);
            customerCache.put(customer.getId(), customer);
        } else {
            throw new IllegalArgumentException("not valid phone number");
        }
    }

    @Override
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    private static boolean isValidPhoneNumber(String phoneNUmber) {
        Matcher matcher = PHONE_PATTERN.matcher(phoneNUmber);
        return matcher.matches();
    }
}
