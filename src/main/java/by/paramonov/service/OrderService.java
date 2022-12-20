package by.paramonov.service;

import by.paramonov.entity.Product;
import by.paramonov.model.DiscountCard;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.price.PriceReader;
import by.paramonov.price.impl.PriceReaderFromFileImpl;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.*;

public class OrderService {

    private static final String OUTPUT_CHECK_FILE_PATH = "src/main/resources/check.txt";

    static final File OUTPUT_CHECK_FILE = new File(OUTPUT_CHECK_FILE_PATH);


    /**
     * Инициализация прайс-листа из файла 'src/main/resources/price.txt'.
     */
    @Getter
    @Setter
    private static List<Product> priceList = new ArrayList<>();

    private final ArgumentService argumentService;
    PriceReader priceReader;


    public OrderService() {
        priceReader = new PriceReaderFromFileImpl();
        argumentService = new ArgumentService();
    }

    //TODO retunr statm Order order
    public Order createOrder(List<ArgumentEntry> argumentEntryList) {
        Order order = new Order();
        Map<Integer, Integer> inputMap = new HashMap<>();
        argumentEntryList.forEach(x -> {
            if (x instanceof ProductEntry) {
                inputMap.put(((ProductEntry) x).getProductId(), ((ProductEntry) x).getProductQuantity());
            } else {
                order.setDiscountCard(DiscountCard.getDiscountCardById(((CardEntry) x).getCardNumber()));
            }
        });
        order.setInputOrder(inputMap);
        setSummaryOrderList(order);
        return order;
    }

    //TODO объединить с методом выше?
    public void setSummaryOrderList(Order order) {
        priceList = priceReader.getPriceList();
        List<String[]> summOrderList = new LinkedList<>();
        order.getInputOrder().forEach((productId, quantity) -> {
            try {
                int quan = quantity;
                Product product = priceList.get(productId);
                double total = quan * product.getPrice();
                if (product.isPromotion()
                        && quan >= Order.quantityForDiscount) {
                    double temptDiscountValuePromotion = total * Order.quantityDiscount;
                    total -= temptDiscountValuePromotion;
                    order.setDiscountValuePromotion(order.getDiscountValuePromotion() + temptDiscountValuePromotion);
                }
                order.setTotalPrice(order.getTotalPrice() + total);
                String[] tempPosition = new String[]{String.format("%d", quan), // quantity
                        product.getDescription(), // description
                        String.format("%.2f", product.getPrice()), // price for one item
                        String.format("%.2f", total)}; // total price for item
                summOrderList.add(tempPosition);
            } catch (NullPointerException nullPointerException) {
                System.out.printf("Product with ID='%d' does not exist yet", productId);
            }
        });
        if (order.getDiscountCard() != null) {
            order.setDiscountValueCard(order.getTotalPrice() * order.getDiscountCard().getDiscountValue());
        }
        order.setTotalDiscount();
        order.setSummaryOrderList(summOrderList);
    }

    public void printCheck(Order order){
        System.out.println(order);
    }
}
