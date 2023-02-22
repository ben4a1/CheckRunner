package by.paramonov.parser.jsonParser.impl;

import by.paramonov.entity.Product;
import by.paramonov.parser.jsonParser.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ProductJsonParser implements JsonParser<Product> {
    private static final String OUTPUT_JSON_FILE_PATH = "src/main/resources/product.json";
    private static final File OUTPUT_JSON_FILE = new File(OUTPUT_JSON_FILE_PATH);

    @Override
    public String toJson(Product productToJson) throws ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> inputMap = new HashMap<>();
        List<Field> fields = Stream.concat(
                Stream.of(Class.forName("by.paramonov.entity.Product").getSuperclass().getDeclaredFields()),
                Stream.of(productToJson.getClass().getDeclaredFields())).toList();
        fields.forEach(field -> {
            field.setAccessible(true);
            try {
                String key = field.getName();
                String value = field.get(productToJson).toString();
                inputMap.put(key, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            field.setAccessible(false);
        });
        stringBuilder
                .append("{\n")
                .append("\t\"id\":").append(inputMap.get("id")).append("L,")
                .append("\n")
                .append("\t\"description\":\"").append(inputMap.get("description")).append("\",")
                .append("\n")
                .append("\t\"price\":").append(inputMap.get("price")).append(",")
                .append("\n")
                .append("\t\"isPromotion\":\"").append(inputMap.get("isPromotion")).append("\"")
                .append("\n}");
        try {
            FileWriter fw = new FileWriter(OUTPUT_JSON_FILE);
            fw.write(stringBuilder.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    @Override
    public Product fromJson(String productFromJson) {
        return new Product();
    }

    public static void main(String[] args) {
        ProductJsonParser productJsonParser = new ProductJsonParser();
        try {
            productJsonParser.toJson(new Product(1L, "thing", 15.15, false));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
