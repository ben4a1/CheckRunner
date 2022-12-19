package by.paramonov.processor;

import by.paramonov.entity.Order;
import by.paramonov.service.OrderService;

public class Processor {
    private final Order order;
    private final OrderService orderService;

    public Processor(){
        order = new Order();
        orderService = new OrderService();
    }
    public void process(String[] args){
        orderService.setInputOrderAndDiscountCard(args, order);
        orderService.setSummaryOrderList(order);
        orderService.printCheck(order);
    }
}
