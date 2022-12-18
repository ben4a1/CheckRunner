package by.paramonov.parser.impl;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.model.DiscountCard;
import by.paramonov.parser.ArgumentParser;

public class ProductArgumentParserImpl implements ArgumentParser {
    @Override
    public boolean isApplicable(String str) {
        return Character.isDigit(str.charAt(0));
    }

    @Override
    public ArgumentEntry parse(String str) {
        ArgumentEntry argumentEntry = new ArgumentEntry();
        String[] split = str.split(regexForSmashArgs);
        argumentEntry.setProductId(Integer.parseInt(split[0]));
        argumentEntry.setProductQuantity(Integer.parseInt(split[1]));
        return argumentEntry;
    }

}
