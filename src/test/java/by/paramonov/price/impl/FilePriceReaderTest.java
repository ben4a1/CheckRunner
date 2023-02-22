package by.paramonov.price.impl;

import by.paramonov.entity.Product;
import by.paramonov.util.ProductBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FilePriceReaderTest {
    private List<Product> productListFromFile;
    private List<Product> productList;
    private ProductBuilder productBuilder;

    @BeforeEach
    void setUp() {
        productBuilder = new ProductBuilder();
        productListFromFile = new FilePriceReader().getPriceList();
        productList = Stream.of(productBuilder
                .withId(1L).withDescription("Shovel").withPrice(41.57).withPromotion(false).build()).collect(Collectors.toList());
    }

    @Test
    void checkGetPriceListShouldReturn() {
        Assertions.assertThat(productListFromFile.get(0)).isEqualTo(productList.get(0));
    }
}