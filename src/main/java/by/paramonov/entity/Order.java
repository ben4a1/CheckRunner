package by.paramonov.entity;


import by.paramonov.model.DiscountCard;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@Setter
public class Order extends BaseEntity {
    static final String CHECK_START = """
            \t\t\tCASH RECEIPT
            SUPERMEGAPUPERMARKET "INFINITY"
            1, Lake street, Somewhereville
            Tel : 321-654-0011\t\tDATE: 
            ++++++++++++++++++++++++++++++++++++++++
            QTY\tDESCRIPTION\t\t\tPRICE\t\tTOTAL""";
    static double vat = 0.2; // НДС 20%
    public static double quantityDiscount = 0.1; // скидка 10% если товар акционный и его количество в заказе более quantityForDiscount

    public static int quantityForDiscount = 6; // количество единиц товара, необходимых для получения акционной скидки
    private DiscountCard discountCard;
    private double totalPrice; // итоговая сумма
    private double discountValuePromotion;
    private double discountValueCard;
    private double totalDiscount;
    private Map<Integer, Integer> inputOrder; // входной набор (productId, quantity) args
    private List<String[]> summaryOrderList; // List по позициям 0-QTY 1-DESCRIPTION 2-PRICE 3-TOTAL

    public void setTotalDiscount(){
        totalDiscount = discountValueCard + discountValuePromotion;
    }

    @Override
    public String toString() {
        int lineLength = 0;
//        summaryOrderList.stream().forEach(x -> {
//
//        });
//
//        int descriptionLength;
//        StringBuilder output = new StringBuilder(CHECK_START);
//        for (String[] position : summaryOrderList) {
//            StringBuilder tempDescription = new StringBuilder(position[1]);
//            String tempString = "";
//            if (position[1].length() < descriptionLength){
//                String white = " ".repeat(descriptionLength - position[1].length());
//                tempDescription.append(white);
//            } else if (position[1].length() > descriptionLength) {
//                String substring = tempDescription.substring(0, descriptionLength);
//                tempDescription.setLength(0);
//                tempDescription.append(substring);
//            }
//                tempString = String.format("%n%s" + "\t%s" + "\t\t$%s" + "\t\t$%s", position[0], tempDescription, position[2], position[3]);
//
//
//
//            output.append(tempString);
//        }
//        return output.toString();
        return null;
    }

}
