package by.paramonov.service;

import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgumentService {
    List<ArgumentParser> argumentParserList = new ArrayList<>();

    public ArgumentService() {
        argumentParserList.add(new ProductArgumentParserImpl());
        argumentParserList.add(new CardArgumentParserImpl());
    }

    public Map<? extends Number, ? extends Number> parseInputArgument(String[] inputArgs) {
        Map<Integer, Integer> parseMap = new HashMap<>();
        if (inputArgs.length != 0) {

        }
        return parseMap;
    }
}
