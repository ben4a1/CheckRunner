package by.paramonov.parser.jsonParser.impl;

import by.paramonov.entity.Product;
import by.paramonov.parser.jsonParser.JsonParser;

public class ProductJsonParser implements JsonParser<Product> {
    @Override
    public String toJson(Product productToJson) {
        return "";
    }

    @Override
    public Product fromJson(String productFromJson) {
        return new Product();
    }
}
