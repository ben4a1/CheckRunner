package by.paramonov.mapper.impl;

import by.paramonov.entity.Product;
import by.paramonov.mapper.JsonMapper;

public class ProductJsonMapper implements JsonMapper<Product> {
    @Override
    public String toJson(Product productToJson) {
        return "";
    }

    @Override
    public Product fromJson(String productFromJson) {
        return new Product();
    }
}
