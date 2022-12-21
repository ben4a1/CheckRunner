package by.paramonov.service;

import by.paramonov.entity.Order;
import by.paramonov.entity.Product;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.price.PriceReader;
import by.paramonov.price.impl.DbPriceReader;
import by.paramonov.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static by.paramonov.util.TestClass.cardEntry;
import static by.paramonov.util.TestClass.productEntry;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {


    @Mock
    PriceReader priceReader;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateOrder() {

        List<Product> mockitoProductList = new ArrayList<>();
        mockitoProductList.add(new Product(1, "first item", 12.4));
        Mockito.when(priceReader.getPriceList()).thenReturn(mockitoProductList);

        List<ArgumentEntry> argumentEntryList = new LinkedList<>();
        argumentEntryList.add(productEntry);
        argumentEntryList.add(cardEntry);

        List<String[]> summOrderList = new LinkedList<>();
        summOrderList.add(new String[]{"0", "sixth item", "6.66", "33.3"});

        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(0, 5);

        Order orderActual = new OrderServiceImpl(priceReader).createOrder(argumentEntryList);
        Order orderExpected = new Order();
        orderExpected.setInputOrder(integerMap);
        orderExpected.setSummaryOrderList(summOrderList);

        assertTrue(orderActual.getInputOrder().equals(orderExpected.getInputOrder()));
    }

    @Test
    void testGetPriceList() {
    }

    @Test
    void testSetPriceList() {
    }
}