package by.paramonov.service;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.model.DiscountCard;
import by.paramonov.parser.ArgumentParser;
import by.paramonov.parser.impl.CardArgumentParserImpl;
import by.paramonov.parser.impl.ProductArgumentParserImpl;

import java.util.*;

public class ArgumentService {
    List<ArgumentParser> argumentParserList;

    public ArgumentService() {
        argumentParserList = new ArrayList<>();
        ArgumentParser productArgumentParser = new ProductArgumentParserImpl();
        ArgumentParser cardArgumentParser = new CardArgumentParserImpl();
        argumentParserList.add(productArgumentParser);
        argumentParserList.add(cardArgumentParser);
    }

    public ArgumentEntry parseArgumentForProduct(String str) {
        int[] ints = Arrays.stream(str.split(ArgumentParser.regexForSmashArgs))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new ArgumentEntry(ints[0], ints[1]);
    }

    public DiscountCard parseArgumentForCard(String str){
        String[] split = str.split(ArgumentParser.regexForSmashArgs);
        return DiscountCard.getDiscountCardById(Integer.parseInt(split[1]));
    }

}
