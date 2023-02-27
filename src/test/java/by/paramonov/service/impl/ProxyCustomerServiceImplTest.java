package by.paramonov.service.impl;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LRUCache;
import by.paramonov.dao.Dao;
import by.paramonov.entity.Customer;
import by.paramonov.model.DiscountCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProxyCustomerServiceImplTest {
    @Mock
    Dao<Customer> customerDao;
    static Cache<Long, Customer> customerCache;

    @BeforeAll
    static void prepare(){
        customerCache = new LRUCache<>(4);
        customerCache.put(1L, new Customer(1, "Aa", "375441234567", 13, false, DiscountCard.WOOD));
        customerCache.put(2L, new Customer(2, "Bb", "375442334567", 23, true, DiscountCard.SILVER));
        customerCache.put(3L, new Customer(3, "XY", "375442334455", 45, true, DiscountCard.GOLD));
        customerCache.put(4L, new Customer(4, "Barbra Joan Streisand", "375291000001", 80, true, DiscountCard.PLATINUM));
    };

    @Test
    void checkAddCustomerShouldReturn4() {
        
    }

    @Test
    void deleteCustomer() {

    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }
}