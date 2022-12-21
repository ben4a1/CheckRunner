package by.paramonov.service;

import by.paramonov.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product); // TODO удалить методы, которые не нужны?

    List<Product> getAll();


}
