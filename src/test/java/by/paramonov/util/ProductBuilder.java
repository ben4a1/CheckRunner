package by.paramonov.util;

import by.paramonov.entity.Product;

public class ProductBuilder {
    private Long id = 1L;
    private String description = "product";
    private Double price = 0.0;
    private Boolean isPromotion = false;

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder withPrice(Double price){
        this.price = price;
        return this;
    }

    public ProductBuilder withPromotion(Boolean isPromotion) {
        this.isPromotion = isPromotion;
        return this;
    }

    public Product build(){
        Product product = new Product(id, description, price, isPromotion);
        return product;
    }
}
