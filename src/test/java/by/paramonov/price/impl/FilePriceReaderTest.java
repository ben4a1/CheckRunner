package by.paramonov.price.impl;

import by.paramonov.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.paramonov.entity.Product.*;

class FilePriceReaderTest {
    private List<Product> productListFromFile;
    private List<Product> productList;

    @BeforeEach
    void setUp() {
        productListFromFile = new FilePriceReader().getPriceList();
        productList = getProductList();
    }

    @Test
    void checkGetPriceListShouldReturnEquals() {
        Assertions.assertThat(productListFromFile.get(1)).isEqualTo(productList.get(1));
    }

    private static List<Product> getProductList() {
        return Stream.of(aProduct()
                                .withId(1L)
                                .withDescription("Shovel")
                                .withPrice(41.57)
                                .withIsPromotion(false)
                                .build(),
                        aProduct()
                                .withId(2L)
                                .withDescription("Vacuum_cleaner")
                                .withPrice(238.60)
                                .build(),
                        aProduct().withId(3L)
                                .withDescription("Laminate")
                                .withPrice(4.50)
                                .build())
                .collect(Collectors.toList());
    }
}