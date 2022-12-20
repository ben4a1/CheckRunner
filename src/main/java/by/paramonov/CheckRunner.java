package by.paramonov;

import by.paramonov.processor.Processor;

public class CheckRunner {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.process(args);
    }
}
