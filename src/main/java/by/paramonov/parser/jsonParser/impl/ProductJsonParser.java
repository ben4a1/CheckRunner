package by.paramonov.parser.jsonParser.impl;

import by.paramonov.entity.Product;
import by.paramonov.parser.jsonParser.JsonParser;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

public class ProductJsonParser implements JsonParser<Product> {
    private static final String JSON_FILE_PATH = "src/main/resources/product.json";
    private static final File JSON_FILE = new File(JSON_FILE_PATH);

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
                .append("\t\"isPromotion\":").append(inputMap.get("isPromotion"))
                .append("\n}");
        try {
            FileWriter fw = new FileWriter(JSON_FILE);
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
        StringBuilder stringBuilder = new StringBuilder();
        ClassLoader classLoader = ProductJsonParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(productFromJson.getName());
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String stringDataFromFile = stringBuilder.toString();
        List<String> fieldsWithValues = Arrays.stream(stringDataFromFile.replaceAll("(\\s|\\{|})", "").split(",")).toList();
        fieldsWithValues.stream().map(x -> x.split(":"))
                .forEach(array -> {
                    String field = array[0].substring(1, array[0].length()-1);
                    String value = array[1];
                    switch (field) {
                        case ("id") -> product.setId(Long.parseLong(value));
                        case ("description") -> product.setDescription(value);
                        case ("price") -> product.setPrice(Double.parseDouble(value));
                        case ("isPromotion") -> product.setPromotion(Boolean.parseBoolean(value));
                        default -> {
                        }
                    }
                });
        return product;
    }
}
