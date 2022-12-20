package by.paramonov.checkprinter.impl;

import by.paramonov.checkprinter.CheckPrinter;
import by.paramonov.entity.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCheckPrinter implements CheckPrinter {
    private static final String OUTPUT_CHECK_FILE_PATH = "src/main/resources/check.txt";
    private static final File OUTPUT_CHECK_FILE = new File(OUTPUT_CHECK_FILE_PATH);

    @Override
    public void printCheck(Order order) {
        String toFile = order.toTextView();
        try {
            FileWriter fw = new FileWriter(OUTPUT_CHECK_FILE);
            fw.write(toFile);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
