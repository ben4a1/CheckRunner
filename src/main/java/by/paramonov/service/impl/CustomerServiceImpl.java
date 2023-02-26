package by.paramonov.service.impl;

import by.paramonov.entity.Customer;
import by.paramonov.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final ProxyCustomerServiceImpl proxyCustomerService;

    public CustomerServiceImpl(ProxyCustomerServiceImpl proxyCustomerService) {
        this.proxyCustomerService = proxyCustomerService;
    }

    @Override
    public void addCustomer(Customer customer) {
        proxyCustomerService.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        proxyCustomerService.deleteCustomer(customerId);
    }

    @Override
    public Customer getById(Long customerId) {
        return proxyCustomerService.getById(customerId);
    }

    @Override
    public void update(Customer customer) {
        proxyCustomerService.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return proxyCustomerService.getAll();
    }
}
