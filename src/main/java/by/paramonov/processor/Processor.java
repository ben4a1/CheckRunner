package by.paramonov.processor;

import by.paramonov.checkprinter.CheckPrinter;
import by.paramonov.checkprinter.impl.FileCheckPrinter;
import by.paramonov.entity.Order;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.service.ArgumentServiceImpl;
import by.paramonov.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Processor {
    private final OrderService orderService;
    private final ArgumentServiceImpl argumentService;
    private final CheckPrinter checkPrinter;

    public Processor(ArgumentServiceImpl argumentService, OrderService orderService, FileCheckPrinter fileCheckPrinter) {
        this.argumentService = argumentService;
        this.orderService = orderService;
        this.checkPrinter = fileCheckPrinter;
    }

    public void process(String[] args) {
        List<ArgumentEntry> argumentEntries = argumentService.parseInputArguments(args);
        Order order = orderService.createOrder(argumentEntries);
        checkPrinter.printCheck(order);
    }

}
