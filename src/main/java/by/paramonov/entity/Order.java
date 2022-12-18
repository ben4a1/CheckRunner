package by.paramonov.entity;


import by.paramonov.model.DiscountCard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Order extends BaseEntity{
    static double vat = 0.2; // НДС 20%
    public static double quantityDiscount = 0.1; // скидка 10% если товар акционный и его количество в заказе более quantityForDiscount

    static int quantityForDiscount = 6; // количество единиц товара, необходимых для получения акционной скидки
    private DiscountCard discountCard;
    private double totalPrice; // итоговая сумма
    private Map<Integer, Integer> inputOrder; // входной набор (Product, quantity) args
    private List<String[]> summaryOrderList; // List по позициям 0-QTY 1-DESCRIPTION 2-PRICE 3-TOTAL
}
