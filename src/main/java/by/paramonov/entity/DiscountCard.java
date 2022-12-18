package by.paramonov.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс скидочной карты
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCard {
    public final static String STATIC_CARD_HOLDER = "Michael Jackson";
    public final static double STATIC_CARD_DISCOUNT = 0.03;
    private long cardId;
    private String cardHolder;
    private double discountValue;
}
