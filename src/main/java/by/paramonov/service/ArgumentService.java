package by.paramonov.service;

import by.paramonov.model.incomearguments.ArgumentEntry;
import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.*;

public class ArgumentService {
    List<ArgumentParser> argumentParserList;

    public ArgumentService() {
        argumentParserList = new ArrayList<>();
        argumentParserList.add(new ProductArgumentParserImpl());
        argumentParserList.add(new CardArgumentParserImpl());
    }

    //TODO argumentParserList.findFirst()
    public List<ArgumentEntry> parseInputArguments(String[] inputArgs) {
        List<ArgumentEntry> argumentEntryList = new LinkedList<>();
        Arrays.stream(inputArgs).forEach(argument ->
                argumentParserList.forEach(parser -> {
                    if (parser.isApplicable(argument)) {
                        argumentEntryList.add(parser.parse(argument));
                    }
                }));
        return argumentEntryList;
    }

}
