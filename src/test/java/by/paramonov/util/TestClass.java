package by.paramonov.util;


import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

public class TestClass {
    public static String productArgument = "0-5";
    public static String cardArgument = "card-1";
    public static ArgumentParser productArgumentParser;
    public static ArgumentParser cardArgumentParser;
    static {
        productArgumentParser = new ProductArgumentParserImpl();
        cardArgumentParser = new CardArgumentParserImpl();
    }
    public static ArgumentEntry productEntry;
    public static ArgumentEntry cardEntry;
    static {
        productEntry = new ProductEntry(TypeOfArgument.PRODUCT, 1, 5);
        cardEntry = new CardEntry(TypeOfArgument.CARD, 1);
    }

}
