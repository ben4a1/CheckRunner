package by.paramonov.service;

import by.paramonov.entity.Order;
import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {



    @Test
    void testCreateOrder() {
        OrderService orderService = new OrderService(); //TODO
        List<ArgumentEntry> argumentEntryList = new LinkedList<>();
        argumentEntryList.add(new ProductEntry(TypeOfArgument.PRODUCT, 1, 5));
        argumentEntryList.add(new CardEntry(TypeOfArgument.CARD, 1));
        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(1, 5);
        Order orderActual = orderService.createOrder(argumentEntryList);
        Order orderExpected = new Order();
        orderExpected.setInputOrder(integerMap);
        assertTrue(orderActual.getInputOrder().equals(orderExpected.getInputOrder()));
    }

    @Test
    void testGetPriceList() {
    }

    @Test
    void testSetPriceList() {
    }
}