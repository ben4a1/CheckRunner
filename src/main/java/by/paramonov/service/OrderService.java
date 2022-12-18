package by.paramonov.service;

import by.paramonov.entity.Order;
import by.paramonov.model.DiscountCard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderService {
    Order order;
    public OrderService(Order order){
        this.order = order;
    }

    public void setInputOrder(String[] inputArgs) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        if (inputArgs.length != 0) {
            Arrays.stream(inputArgs).forEach(x -> {
                String[] split = x.split("-");
                if (Character.isDigit(split[0].charAt(0))) {
                    int tempId = Integer.parseInt(split[0]);
                    int tempQuantity = Integer.parseInt(split[1]);
                    if (!inputMap.containsKey(tempId)) {
                        inputMap.put(tempId, tempQuantity);
                    } else {
                        int existingCount = inputMap.get(tempId);
                        inputMap.put(tempId, tempQuantity + existingCount);
                    }
                } else if (split[0].equalsIgnoreCase("card")) {
                    order.setDiscountCard(DiscountCard.getDiscountCardById(Integer.parseInt(split[1])));
                }
            });
            order.setInputOrder(inputMap);

        }
    }

    public void setSummaryOrderList(Order order){

    }
}
