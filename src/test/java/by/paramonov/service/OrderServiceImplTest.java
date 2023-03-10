package by.paramonov.service;

import by.paramonov.entity.Order;
import by.paramonov.entity.Product;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.price.PriceReader;
import by.paramonov.price.impl.DbPriceReader;
import by.paramonov.repository.ProductRepository;
import by.paramonov.service.impl.OrderServiceImpl;
import by.paramonov.service.impl.ProductServiceImpl;
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
    PriceReader mockitoPriceReader;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateOrder() {

        List<Product> mockitoProductList = new ArrayList<>();
        mockitoProductList.add(new Product(0, "first item", 12.4));
        Mockito.when(mockitoPriceReader.getPriceList()).thenReturn(mockitoProductList);

        List<ArgumentEntry> argumentEntryList = new LinkedList<>();
        argumentEntryList.add(productEntry);
        argumentEntryList.add(cardEntry);

        List<String[]> summOrderList = new LinkedList<>();
        summOrderList.add(new String[]{"0", "first item", "12.4", "62"});

        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(0, 5);

        Order orderActual = new OrderServiceImpl(mockitoPriceReader).createOrder(argumentEntryList);
        Order orderExpected = new Order();
        orderExpected.setInputOrder(integerMap);
        orderExpected.setSummaryOrderList(summOrderList);

        assertEquals(orderActual.getInputOrder(), orderExpected.getInputOrder());
    }

}