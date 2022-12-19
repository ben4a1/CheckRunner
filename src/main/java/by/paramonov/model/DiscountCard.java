package by.paramonov.model;


import lombok.Getter;

import java.util.Arrays;

/**
 * Класс (enum) скидочной карты
 */

@Getter
public enum DiscountCard {

    WOOD(1, "novice buyer", 0.015d),
    SILVER(2, "normal buyer", 0.03d),
    GOLD(3, "good buyer", 0.05d),
    PLATINUM(4, "perfect buyer", 0.07d);

    private final long cardId;
    private final String cardHolder;
    private final double discountValue;

    DiscountCard(long cardId, String cardHolder, double discountValue) {
        this.cardId = cardId;
        this.cardHolder = cardHolder;
        this.discountValue = discountValue;
    }

    public static DiscountCard getDiscountCardById(int id) {
        for (DiscountCard dc : values()) {
            if (dc.cardId == id) {
                return dc;
            }
        }
        System.out.printf("Discount card with %d is not exists yet", id);
        return null;
    }
}
