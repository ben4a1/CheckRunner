package by.paramonov.service;

import by.paramonov.entity.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.model.DiscountCard;
import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.*;

public class OrderService {

    private Order order;
    ArgumentParser productArgumentParser;
    ArgumentParser cardArgumentParser;

    public OrderService() {
        order = new Order();
        productArgumentParser = new ProductArgumentParserImpl();
        cardArgumentParser = new CardArgumentParserImpl();
    }


    public void setInputOrderAndDiscountCard(String[] inputArgs) {
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
        }
    }
//                String[] split = x.split("-");
//                if (Character.isDigit(split[0].charAt(0))) {
//                    int tempId = Integer.parseInt(split[0]);
//                    int tempQuantity = Integer.parseInt(split[1]);
//                    if (!inputMap.containsKey(tempId)) {
//                        inputMap.put(tempId, tempQuantity);
//                    } else {
//                        int c = inputMap.get(tempId);
//                        inputMap.put(tempId, tempQuantity + existingCount);
//                    }
//                } else if (split[0].equalsIgnoreCase("card")) {
//                    order.setDiscountCard(DiscountCard.getDiscountCardById(Integer.parseInt(split[1])));
//                }
//            });
//            order.setInputOrder(inputMap);
//        }


//    public void setSummaryOrderList(Order order){
//
//    }
}
