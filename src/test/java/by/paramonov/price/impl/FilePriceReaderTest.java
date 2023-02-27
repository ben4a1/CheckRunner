package by.paramonov.price.impl;

import by.paramonov.entity.Product;
import by.paramonov.util.ProductBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                        .withId(1L).withDescription("Shovel").withPrice(41.57).withPromotion(false).build(),
                productBuilder
                        .withId(2L).withDescription("Vacuum_cleaner").withPrice(238.60).build(),
                productBuilder.withId(3L).withDescription("Laminate").withPrice(4.50).build()).collect(Collectors.toList());
    }

    @Test
    void checkGetPriceListShouldReturnEquals() {
        Assertions.assertThat(productListFromFile.get(1)).isEqualTo(productList.get(1));
    }
}