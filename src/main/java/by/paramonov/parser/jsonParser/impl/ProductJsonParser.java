package by.paramonov.parser.jsonParser.impl;

import by.paramonov.entity.Product;
import by.paramonov.parser.jsonParser.JsonParser;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ProductJsonParser implements JsonParser<Product> {
    private static final String OUTPUT_JSON_FILE_PATH = "src/main/resources/product.json";
    private static final File OUTPUT_JSON_FILE = new File(OUTPUT_JSON_FILE_PATH);

    @Override
    public String toJson(Product productToJson) throws ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> inputMap = new HashMap<>();
        List<Field> fields = Stream.concat(
                Stream.of(Product.class.getSuperclass().getDeclaredFields()),
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
                .append("\t\"id\":").append(inputMap.get("id")).append(",")
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
    public Product fromJson(File productFromJson) {
        Product product = new Product();
        String replace = productFromJson.replaceAll("\\s", "");
        System.out.println(replace);
        return product;
    }

    public static void main(String[] args) {
        ProductJsonParser productJsonParser = new ProductJsonParser();
        try {
            productJsonParser.toJson(new Product(1L, "thing", 15.15, false));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ClassLoader classLoader = ProductJsonParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("product.json");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String data = stringBuilder.toString();
        productJsonParser.fromJson(data);
        System.out.println(data);
    }
}
