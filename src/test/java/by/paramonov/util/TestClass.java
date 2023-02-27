package by.paramonov.util;


import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.parser.argumentParser.ArgumentParser;
import by.paramonov.parser.argumentParser.impl.CardArgumentParserImpl;
import by.paramonov.parser.argumentParser.impl.ProductArgumentParserImpl;

import java.util.LinkedList;
import java.util.List;

public class TestClass {
    public static String productArgument = "0-5";
    public static String cardArgument = "card-1";
    public static ArgumentParser productArgumentParser;
    public static ArgumentParser cardArgumentParser;
    static {
        productArgumentParser = new ProductArgumentParserImpl();
        cardArgumentParser = new CardArgumentParserImpl();
    }
    public static List<ArgumentParser> argumentParserList = new LinkedList<>();
    static {
        argumentParserList.add(productArgumentParser);
        argumentParserList.add(cardArgumentParser);
    }
    public static ArgumentEntry productEntry;
    public static ArgumentEntry cardEntry;
    static {
        productEntry = new ProductEntry(TypeOfArgument.PRODUCT, 0, 5);
        cardEntry = new CardEntry(TypeOfArgument.CARD, 1);
    }

    public static List<ArgumentEntry> argumentEntryList = new LinkedList<>();
    static {
        argumentEntryList.add(productEntry);
        argumentEntryList.add(cardEntry);
    }

}
