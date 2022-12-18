package by.paramonov.service;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.*;

public class OrderService {

    private final Order order;
    ArgumentParser productArgumentParser;
    ArgumentParser cardArgumentParser;

    public OrderService() {
        order = new Order();
        productArgumentParser = new ProductArgumentParserImpl();
        cardArgumentParser = new CardArgumentParserImpl();
    }


    public void setInputOrderAndDiscountCard(String[] inputArgs, Order order) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        if (inputArgs.length != 0) {
            Arrays.stream(inputArgs).forEach(x -> {
                if (productArgumentParser.isApplicable(x)) {
                    ArgumentEntry argumentEntry = productArgumentParser.parseProduct(x);
                    if (!inputMap.containsKey(argumentEntry.getProductId())) {
                        inputMap.put(argumentEntry.getProductId(), argumentEntry.getProductQuantity());
                    } else {
                        int existingCount = inputMap.get(argumentEntry.getProductId());
                        inputMap.put(argumentEntry.getProductId(), argumentEntry.getProductQuantity() + existingCount);
                    }
                } else if (cardArgumentParser.isApplicable(x)) {
                    order.setDiscountCard(cardArgumentParser.parseCard(x));
                }

            });
            order.setInputOrder(inputMap);
        }
    }

}
