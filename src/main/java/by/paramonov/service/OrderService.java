package by.paramonov.service;

import by.paramonov.model.incomearguments.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.parser.ArgumentParser;

import java.util.*;

public class OrderService {

    private final Order order;

    public OrderService() {
        order = new Order();
        ArgumentService argumentService = new ArgumentService();
    }


    public void setInputOrderAndDiscountCard(String[] inputArgs, Order order) {
        Map<Integer, Integer> inputMap = new HashMap<>();

    }
//if(inputArgs.length !=0)
//
//    {
//        Arrays.stream(inputArgs).forEach(x -> {
//            if (productArgumentParser.isApplicable(x)) {
//                ArgumentEntry argumentEntry = productArgumentParser.parseProduct(x);
//                if (!inputMap.containsKey(argumentEntry.getProductId())) {
//                    inputMap.put(argumentEntry.getProductId(), argumentEntry.getProductQuantity());
//                } else {
//                    int existingCount = inputMap.get(argumentEntry.getProductId());
//                    inputMap.put(argumentEntry.getProductId(), argumentEntry.getProductQuantity() + existingCount);
//                }
//            } else if (cardArgumentParser.isApplicable(x)) {
//                order.setDiscountCard(cardArgumentParser.parseCard(x));
//            }
//
//        });
//        order.setInputOrder(inputMap);
//    }
}
