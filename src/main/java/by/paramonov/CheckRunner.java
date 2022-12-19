package by.paramonov;

import by.paramonov.processor.Processor;
import by.paramonov.service.OrderService;

public class CheckRunner {
    public static void main(String[] args) {
        String[] argsForDebug = new String[]{"3-5", "8-25", "1-4", "2-5", "card-1"};
        System.out.println(OrderService.priceListFromFile.get(6));


        Processor processor = new Processor();
        processor.process(argsForDebug);
    }
}
