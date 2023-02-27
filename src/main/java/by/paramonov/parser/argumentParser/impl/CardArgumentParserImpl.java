package by.paramonov.parser.argumentParser.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.parser.argumentParser.ArgumentParser;
import org.springframework.stereotype.Component;

@Component
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
