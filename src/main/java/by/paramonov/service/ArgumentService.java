package by.paramonov.service;

import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.HashMap;
import java.util.Map;

public class ArgumentService {
    ArgumentParser apProduct = new ProductArgumentParserImpl();
    ArgumentParser apCard = new CardArgumentParserImpl();

    public Map<? extends Number, ? extends Number> parseInputArgument(String[] inoutArgs){
        Map<Integer, Integer> parseMap = new HashMap<>();

        return parseMap;
    }
}
