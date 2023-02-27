package by.paramonov.entity;

import by.paramonov.model.DiscountCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity {
    private String firstName;
    private String phoneNumber;
    private int age;
    private boolean isWorkable;
    private DiscountCard discountCard;

    public Customer(long id, String firstName, String phoneNumber, int age, boolean isWorkable, DiscountCard discountCard) {
        super(id);
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.isWorkable = isWorkable;
        this.discountCard = discountCard;
    }

}
