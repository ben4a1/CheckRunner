package by.paramonov.entity;

import by.paramonov.model.DiscountCard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends BaseEntity{
    private String firstName;
    private String phoneNumber;
    private int age;
    private boolean isWorkable;
    private DiscountCard discountCard;
}
