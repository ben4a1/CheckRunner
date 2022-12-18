package by.paramonov.parser.impl;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.model.DiscountCard;
import by.paramonov.parser.ArgumentParser;

public class CardArgumentParserImpl implements ArgumentParser {

    @Override
    public boolean isApplicable(String str) {
        return str.toLowerCase().startsWith("card");
    }

    public ArgumentEntry parse(String str) {
        String[] split = str.split(regexForSmashArgs);
        return DiscountCard.getDiscountCardById(Integer.parseInt(split[1]));
    }

}
