package by.paramonov.entity;


import by.paramonov.model.DiscountCard;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Order extends BaseEntity {
    static final String CASH_RECEIPT = "CASH RECEIPT";
    static final String MARKET_NAME = "\"SUPERMEGAPUPERMARKET \"INFINITY\"";
    static final String MARKET_ADDRESS = "1, Lake street, Somewhereville";
    static final String MARKET_PHONE_NUMBER = "Tel : 321-654-0011";
    static final String CASHIER = "CASHIER :  #2022";
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

    public void setTotalDiscount() {
        totalDiscount = discountValueCard + discountValuePromotion;
    }

    @Override
    public String toString() {

        int priceLength = summaryOrderList.stream().mapToInt(x -> x[2].length()).max().getAsInt();
        int descriptionLength = summaryOrderList.stream().mapToInt(x -> x[1].length()).max().getAsInt();
        int totalLength = summaryOrderList.stream().mapToInt(x -> x[3].length()).max().getAsInt();
        int lineLength = 6 + priceLength + descriptionLength + totalLength; // 6 - по 2 пробела после каждого из 3-х первых столбцов
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String plusLine = "+".repeat(lineLength + 2);
        String emptyLine = " ".repeat(lineLength);
        String cashReceiptLine = emptyLine.substring(0, lineLength / 2 - CASH_RECEIPT.length() / 2) + CASH_RECEIPT;
        String output = plusLine
                        + "\n" + cashReceiptLine;
        String marketNameLine = emptyLine.substring(0, lineLength / 2 - MARKET_NAME.length() / 2) + MARKET_NAME;
        output += "\n" + marketNameLine;
        String marketAddressLine = emptyLine.substring(0, lineLength / 2 - MARKET_ADDRESS.length() / 2) + MARKET_ADDRESS;
        output += "\n" + marketAddressLine;
        String marketPhoneNumberLine = emptyLine.substring(0, lineLength / 2 - MARKET_PHONE_NUMBER.length() / 2) + MARKET_PHONE_NUMBER;
        output += "\n" + marketPhoneNumberLine;
        output += "\n" + CASHIER;
        String dateStr = dateFormat.format(date);
        output += emptyLine.substring(0, lineLength - CASHIER.length() - dateStr.length()) + dateStr;
        String timeStr = timeFormat.format(date);
        output += "\n" + emptyLine.substring(timeStr.length()) + timeStr;

        output += "\n" + plusLine;
        output += "\n" + "QTY" + " ".repeat(2) + "+"
                  + " DESCRIPTION" + " ".repeat(descriptionLength - 10) + "+"
                  + " PRICE" + " ".repeat(priceLength - 4) + "+"
                  + " TOTAL" + " ".repeat(totalLength - 4);
        output += "\n" + plusLine;

//        StringBuilder output = new StringBuilder(FIRST_LINE);
//        for (String[] position : summaryOrderList) {
//            StringBuilder tempDescription = new StringBuilder(position[1]);
//            String tempString = "";
//            if (position[1].length() < descriptionLength) {
//                String white = " ".repeat(descriptionLength - position[1].length());
//                tempDescription.append(white);
//            } else if (position[1].length() > descriptionLength) {
//                String substring = tempDescription.substring(0, descriptionLength);
//                tempDescription.setLength(0);
//                tempDescription.append(substring);
//            }
//            tempString = String.format("%n%s" + "\t%s" + "\t\t$%s" + "\t\t$%s", position[0], tempDescription, position[2], position[3]);
//
//
//            output.append(tempString);
//        }
//        return output.toString();
        return output;
    }

}
