package by.paramonov.parser.impl;

import by.paramonov.model.incomearguments.ArgumentEntry;
import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomearguments.CardEntry;
import by.paramonov.parser.ArgumentParser;
import lombok.experimental.PackagePrivate;

public class CardArgumentParserImpl implements ArgumentParser {

    @Override
    public boolean isApplicable(String str) {
        return str.toLowerCase().startsWith("card");
    }

    @Override
    public <T extends ArgumentEntry> ArgumentEntry parse(String str) {
        String[] split = str.split(regexForSmashArgs);
        return new CardEntry(TypeOfArgument.CARD, Integer.parseInt(split[1]));
    }

}
