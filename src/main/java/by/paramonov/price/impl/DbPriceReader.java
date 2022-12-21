package by.paramonov.price.impl;

import by.paramonov.entity.Product;
import by.paramonov.price.PriceReader;
import by.paramonov.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbPriceReader implements PriceReader {

    private final ProductService productService;
    public DbPriceReader(ProductService productService){
        this.productService = productService;
    }
    @Override
    public List<Product> getPriceList() {
        return productService.getAll();
    }
}
