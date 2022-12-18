package by.paramonov.entity;

import lombok.Data;

@Data
public class Product extends BaseEntity{
    private String description;
    private double price;
    private boolean isPromotion;
//    private String category;

    public Product(long id, String description, double price) {
        super();
        this.description = description;
        this.price = price;
    }
}
