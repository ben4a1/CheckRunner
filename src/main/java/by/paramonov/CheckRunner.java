package by.paramonov;

import by.paramonov.processor.Processor;
import by.paramonov.service.CheckService;

public class CheckRunner {
    public static void main(String[] args) {
        String[] argsForDebug = new String[]{"3-5", "4-25", "1-4", "2-5", "card-2"};
        System.out.println(CheckService.priceListFromFile.get(5));


        Processor processor = new Processor();
        processor.process(argsForDebug);
    }
}
