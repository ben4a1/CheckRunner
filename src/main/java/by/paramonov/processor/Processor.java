package by.paramonov.processor;

import by.paramonov.entity.Order;
import by.paramonov.service.ArgumentService;
import by.paramonov.service.CheckService;
import by.paramonov.service.OrderService;

public class Processor {
    private final Order order;
    private final ArgumentService argumentService;
    private final CheckService checkService;
    private final OrderService orderService;

    public Processor(){
        order = new Order();
        argumentService = new ArgumentService();
        checkService = new CheckService();
        orderService = new OrderService();
    }
    public void process(String[] args){
        orderService.setInputOrderAndDiscountCard(args, order);

    }
}
