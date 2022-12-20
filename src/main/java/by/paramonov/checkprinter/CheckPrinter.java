package by.paramonov.checkprinter;

import by.paramonov.entity.Order;

public interface CheckPrinter {
    void printCheck(Order order);
}
