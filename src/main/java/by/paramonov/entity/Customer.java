package by.paramonov.entity;

import by.paramonov.model.DiscountCard;

public class Customer extends BaseEntity{
    private String firstName;
    private String phoneNumber;
    private int age;
    private Order order;
    private DiscountCard discountCard;
}
