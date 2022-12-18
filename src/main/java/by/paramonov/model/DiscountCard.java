package by.paramonov.model;


import lombok.Getter;

import java.util.Arrays;

/**
 * Класс скидочной карты
 */

public enum DiscountCard {

    WOOD(1, "novice buyer", 0.015),
    SILVER(2, "normal buyer", 0.03),
    GOLD(3, "good buyer", 0.05),
    PLATINUM(4, "perfect buyer", 0.07);

    @Getter
    private final long cardId;
    @Getter
    private final String cardHolder;
    @Getter
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
        return null;
    }
}
