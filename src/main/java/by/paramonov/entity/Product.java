package by.paramonov.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@AttributeOverride(name = "id", column = @Column(name = "product_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Product(String description, double price, boolean isPromotion) {
        this.description = description;
        this.price = price;
        this.isPromotion = isPromotion;
    }

    public Product(long id, String description, double price, boolean isPromotion) {
        super(id);
        this.description = description;
        this.price = price;
        this.isPromotion = isPromotion;
    }
}
