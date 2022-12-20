package by.paramonov.service;

import by.paramonov.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    List<Product> getAll();


}
