package by.paramonov.service;

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


}
