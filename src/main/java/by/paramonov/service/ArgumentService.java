package by.paramonov.service;

import by.paramonov.entity.ArgumentEntry;
import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.*;

public class ArgumentService {
    List<ArgumentParser> argumentParserList = new ArrayList<>();

    public ArgumentService() {
        argumentParserList.add(new ProductArgumentParserImpl());
        argumentParserList.add(new CardArgumentParserImpl());
    }

    public List<ArgumentEntry> parseInputArguments(String[] inputArgs) {
        List<ArgumentEntry> parseList = new LinkedList<>();
        if (inputArgs.length != 0) {
            Arrays.stream(inputArgs).forEach(el -> {

            });
        }
        return parseList;
    }
}
