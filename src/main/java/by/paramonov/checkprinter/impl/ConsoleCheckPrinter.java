package by.paramonov.checkprinter.impl;

import by.paramonov.checkprinter.CheckPrinter;
import by.paramonov.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class ConsoleCheckPrinter implements CheckPrinter {
    @Override
    public void printCheck(Order order) {
        String toConsole = order.toTextView();
        System.out.println(toConsole);
    }
}
