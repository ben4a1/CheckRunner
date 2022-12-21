package by.paramonov.parser.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.parser.ArgumentParser;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProductArgumentParserImpl implements ArgumentParser {
    @Override
    public boolean isApplicable(String str) {
        return Character.isDigit(str.charAt(0));
    }

    @Override
    public <T extends ArgumentEntry> ArgumentEntry parse(String str) {
        int[] ints = Arrays.stream(str.split(ArgumentParser.regexForSmashArgs))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new ProductEntry(TypeOfArgument.PRODUCT, ints[0], ints[1]);
    }

}
