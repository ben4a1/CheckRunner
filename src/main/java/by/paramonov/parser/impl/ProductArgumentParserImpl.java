package by.paramonov.parser.impl;

import by.paramonov.entity.ArgumentEntry;
import by.paramonov.parser.ArgumentParser;

public class ProductArgumentParserImpl implements ArgumentParser {
    @Override
    public boolean isApplicable(String str) {
        return Character.isDigit(str.charAt(0));
    }

    @Override
    public ArgumentEntry parse(String string) {

        return null;
    }
}
