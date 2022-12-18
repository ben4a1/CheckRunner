package by.paramonov.app;

import by.paramonov.entity.Check;
import by.paramonov.entity.Order;
import by.paramonov.service.ArgumentService;
import by.paramonov.service.CheckService;
import by.paramonov.service.OrderService;

public class Processor {
    private final Check check;
    private final Order order;
    private final ArgumentService argumentService;
    private final CheckService checkService;
    private final OrderService orderService;

    public Processor(){
        check = new Check();
        order = new Order();
        argumentService = new ArgumentService();
        checkService = new CheckService();
        orderService = new OrderService();
    }
    public void start(String[] args){

    }
}
