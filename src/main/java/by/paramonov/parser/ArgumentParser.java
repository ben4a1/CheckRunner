package by.paramonov.parser;

import by.paramonov.entity.ArgumentEntry;

public interface ArgumentParser {
    boolean isApplicable(String str);
    ArgumentEntry parse(String string);
}
