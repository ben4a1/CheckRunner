package by.paramonov.processor;

import by.paramonov.checkprinter.CheckPrinter;
import by.paramonov.checkprinter.impl.ConsoleCheckPrinter;
import by.paramonov.entity.Order;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.service.ArgumentService;
import by.paramonov.service.OrderService;

import java.util.List;

public class Processor {
    private final OrderService orderService;
    private final ArgumentService argumentService;
    private final CheckPrinter checkPrinter;

    public Processor() {
        argumentService = new ArgumentService();
        orderService = new OrderService();
        checkPrinter = new ConsoleCheckPrinter();
    }

    public void process(String[] args) {
        List<ArgumentEntry> argumentEntries = argumentService.parseInputArguments(args);
        Order order = orderService.createOrder(argumentEntries);
        System.out.println(order);
//        checkPrinter.printCheck(order);
    }

}
