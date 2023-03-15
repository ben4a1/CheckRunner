package by.paramonov.service.impl;

import by.paramonov.entity.Order;
import by.paramonov.model.DiscountCard;
import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.service.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RestServiceImpl implements RestService {
    private OrderServiceImpl orderService;

    public RestServiceImpl(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @Override
    public String check(List<String> items, Long cardId) {
        List<ArgumentEntry> argumentEntryList = new ArrayList<>();
        if (Arrays.stream(DiscountCard.values())
                .mapToLong(DiscountCard::getCardId)
                .anyMatch(id -> id == cardId)) {
            argumentEntryList.add(new CardEntry(TypeOfArgument.CARD, cardId.intValue()));
        }
        items.forEach(item -> {
            String[] split = item.split("-");
            argumentEntryList.add(new ProductEntry(TypeOfArgument.PRODUCT, Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        });
        Order order = orderService
                .createOrder(argumentEntryList);
        ObjectMapper om = new ObjectMapper();
        String view = null;
        try {
            view = om.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return view;
    }
}
