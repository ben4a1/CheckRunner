package by.paramonov.service;

import by.paramonov.entity.Order;
import by.paramonov.entity.Product;
import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.price.PriceReader;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {


    @Mock
    PriceReader priceReader;
    @Test
    void testCreateOrder() {

        List<Product> mockitoProductList = new ArrayList<>();
        mockitoProductList.add(new Product());
        mockitoProductList.add(new Product());
        mockitoProductList.add(new Product());
        Mockito.when(priceReader.getPriceList()).thenReturn(mockitoProductList);
        List<ArgumentEntry> argumentEntryList = new LinkedList<>();
        argumentEntryList.add(new ProductEntry(TypeOfArgument.PRODUCT, 1, 5));
        argumentEntryList.add(new CardEntry(TypeOfArgument.CARD, 1));
        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(1, 5);
//        Order orderActual = orderService.createOrder(argumentEntryList);
        Order orderExpected = new Order();
        orderExpected.setInputOrder(integerMap);
//        assertTrue(orderActual.getInputOrder().equals(orderExpected.getInputOrder()));
    }

    @Test
    void testGetPriceList() {
    }

    @Test
    void testSetPriceList() {
    }
}