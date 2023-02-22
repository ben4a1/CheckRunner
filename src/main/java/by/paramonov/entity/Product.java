package by.paramonov.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(product.price, price) == 0 && isPromotion == product.isPromotion && description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, isPromotion);
    }
}
