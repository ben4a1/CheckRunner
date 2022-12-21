package by.paramonov.service.impl;

import by.paramonov.entity.Product;
import by.paramonov.model.DiscountCard;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.price.PriceReader;
import by.paramonov.price.impl.DbPriceReader;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl {

    @Getter
    @Setter
    private static List<Product> priceList = new ArrayList<>();

    PriceReader priceReader;

    public OrderServiceImpl(DbPriceReader dbPriceReader) {
        priceReader = dbPriceReader;
    }

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

    private void setSummaryOrderList(Order order) {
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

}
