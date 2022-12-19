package by.paramonov.service;

import by.paramonov.model.DiscountCard;
import by.paramonov.model.incomearguments.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.model.incomearguments.CardEntry;
import by.paramonov.model.incomearguments.ProductEntry;
import by.paramonov.parser.ArgumentParser;

import java.util.*;

public class OrderService {

    private final ArgumentService argumentService;

    public OrderService() {
        Order order = new Order();
        argumentService = new ArgumentService();
    }


    public void setInputOrderAndDiscountCard(String[] inputArgs, Order order) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        List<ArgumentEntry> argumentEntries = argumentService.parseInputArguments(inputArgs);
        argumentEntries.forEach(x -> {
            if(x instanceof ProductEntry) {
                inputMap.put(((ProductEntry) x).getProductId(), ((ProductEntry) x).getProductQuantity());
            } else {
                order.setDiscountCard(DiscountCard.getDiscountCardById(((CardEntry) x).getCardNumber()));
            }
        });
        order.setInputOrder(inputMap);
    }
//      if(inputArgs.length !=0) {
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
