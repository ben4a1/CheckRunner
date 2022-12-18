package by.paramonov.parser.impl;

import by.paramonov.model.DiscountCard;
import by.paramonov.parser.ArgumentParser;

public class CardArgumentParserImpl implements ArgumentParser {

    @Override
    public boolean isApplicable(String str) {
        String[] split = str.split(regexForSmashArgs);
        return split[0].equalsIgnoreCase("card");
    }

    public DiscountCard parse(String str) {
        String[] split = str.split(regexForSmashArgs);
        return DiscountCard.getDiscountCardById(Integer.parseInt(split[1]));
    }

}
