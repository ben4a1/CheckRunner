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

import static java.lang.String.format;

@Getter
@Setter
public class Order extends BaseEntity {
    static final String CASH_RECEIPT = "CASH RECEIPT";
    static final String MARKET_NAME = "\"SUPERMEGAPUPERMARKET \"INFINITY\"";
    static final String MARKET_ADDRESS = "1, Lake street, Somewhereville";
    static final String MARKET_PHONE_NUMBER = "Tel : 321-654-0011";
    static final String CASHIER = "CASHIER :  #2022";
    static final String START_FIRST_LINE_OF_THE_END = "TAXABLE TOT.";
    static final String START_THIRD_LINE_OF_THE_END = "TOTAL DISCOUNT";
    private static final String START_FOURTH_LINE_OF_THE_END = "TOTAL";
    static double vat = 0.2; // НДС 20%
    static final String START_SECOND_LINE_OF_THE_END = format("VAT%.2f%%", (Order.vat * 100));
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

    //TODO toString удалить, всё в printCheck?
    //TODO попроще    toTextView()
    @Override
    public String toString() {
        int qtyLength = summaryOrderList.stream().mapToInt(x -> x[0].length()).max().getAsInt();
        int priceLength = summaryOrderList.stream().mapToInt(x -> x[2].length()).max().getAsInt();
        int descriptionLength = summaryOrderList.stream().mapToInt(x -> x[1].length()).max().getAsInt();
        int totalLength = summaryOrderList.stream().mapToInt(x -> x[3].length()).max().getAsInt();
        int lineLength = 12 + qtyLength + priceLength + descriptionLength + totalLength;
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String dateStr = dateFormat.format(date);
        String timeStr = timeFormat.format(date);
        String plusLine = "+".repeat(lineLength + 2);
        String emptyLine = " ".repeat(lineLength);
        String whiteSpaceAndPlusLine = " ".repeat(5) + "+" + " ".repeat(descriptionLength + 2) + "+" + " ".repeat(priceLength + 2) + "+";
        String cashReceiptLine = emptyLine.substring(0, lineLength / 2 - CASH_RECEIPT.length() / 2) + CASH_RECEIPT;
        StringBuilder output = new StringBuilder(plusLine
                                                 + "\n" + cashReceiptLine);
        String marketNameLine = emptyLine.substring(0, lineLength / 2 - MARKET_NAME.length() / 2) + MARKET_NAME;
        output.append("\n").append(marketNameLine);
        String marketAddressLine = emptyLine.substring(0, lineLength / 2 - MARKET_ADDRESS.length() / 2) + MARKET_ADDRESS;
        output.append("\n").append(marketAddressLine);
        String marketPhoneNumberLine = emptyLine.substring(0, lineLength / 2 - MARKET_PHONE_NUMBER.length() / 2) + MARKET_PHONE_NUMBER;
        output.append("\n").append(marketPhoneNumberLine);
        output.append("\n" + CASHIER);
        output.append(emptyLine, 0, lineLength - CASHIER.length() - dateStr.length()).append(dateStr);
        output.append("\n")
                .append(emptyLine.substring(timeStr.length()))
                .append(timeStr)
                .append("\n")
                .append(plusLine)
                .append("\n" + "QTY") // Верхняя граница построчного представления чека/заказа
                .append(" ".repeat(2))
                .append("+").append(" DESCRIPTION")
                .append(" ".repeat(descriptionLength - 10))
                .append("+")
                .append(" PRICE")
                .append(" ".repeat(priceLength - 4))
                .append("+")
                .append(" TOTAL")
                .append(" ".repeat(totalLength - 4))
                .append("\n")
                .append(plusLine)
                .append("\n")
                .append(whiteSpaceAndPlusLine);
        // Построчное представления чека/заказа
        summaryOrderList.forEach(position -> {
            String tempQTY = position[0];
            String tempDescription = position[1];
            String tempPrice = format("$%s", position[2]);
            String tempTotal = format("$%s", position[3]);
            output.append("\n")
                    .append(tempQTY)
                    .append(" ".repeat(5 - tempQTY.length()))
                    .append("+").append(" ")
                    .append(tempDescription)
                    .append(" ".repeat(descriptionLength - tempDescription.length() + 1))
                    .append("+").append(" ")
                    .append(tempPrice)
                    .append(" ".repeat(priceLength - tempPrice.length() + 1))
                    .append("+").append(" ")
                    .append(tempTotal);

        });
        // нижняя граница построчного представления чека/заказа
        output.append("\n")
                .append(emptyLine)
                .append("\n")
                .append(plusLine).append("\n")
                .append(START_FIRST_LINE_OF_THE_END)
                .append(" ".repeat(lineLength - START_FIRST_LINE_OF_THE_END.length() - format("$%.2f", totalPrice).length()))
                .append(format("$%.2f", totalPrice))
                .append("\n")
                .append(START_SECOND_LINE_OF_THE_END)
                .append(" ".repeat(lineLength - START_SECOND_LINE_OF_THE_END.length() - format("$%.2f", totalPrice * vat).length() - 1))
                .append(format("$%.2f", totalPrice * vat))
                .append("\n")
                .append(START_THIRD_LINE_OF_THE_END)
                .append(" ".repeat(lineLength - START_THIRD_LINE_OF_THE_END.length() - format("$%.2f", totalDiscount).length() - 2))
                .append(format("$%.2f", totalDiscount))
                .append("\n")
                .append(START_FOURTH_LINE_OF_THE_END)
                .append(" ".repeat(lineLength - START_FOURTH_LINE_OF_THE_END.length() - format("$%.2f", totalPrice).length()))
                .append(format("$%.2f", totalPrice + (totalPrice * vat)));
        return output.toString();
    }

}
