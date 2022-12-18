package by.paramonov;

import by.paramonov.app.Processor;
import by.paramonov.entity.Order;
import by.paramonov.service.CheckService;
import by.paramonov.service.OrderService;

public class CheckRunner {
    public static void main(String[] args) {
        String[] argsForDebug = new String[]{"3-5", "4-25", "1-4", "2-5", "card-2"};
        System.out.println(CheckService.priceListFromFile.get(4));
        System.out.println();


        Processor processor = new Processor();
        processor.start(argsForDebug);
    }
}
