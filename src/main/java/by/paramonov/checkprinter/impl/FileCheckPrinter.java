package by.paramonov.checkprinter.impl;

import by.paramonov.checkprinter.CheckPrinter;
import by.paramonov.entity.Order;

import java.io.File;

public class FileCheckPrinter implements CheckPrinter {
    private static final String OUTPUT_CHECK_FILE_PATH = "src/main/resources/check.txt";

    private static final File OUTPUT_CHECK_FILE = new File(OUTPUT_CHECK_FILE_PATH);

    @Override
    public void printCheck(Order order) {
        //TODO логику формирования вынести куда?
        System.out.println(order.getSummaryOrderList());
    }
}
