package by.paramonov.parser;

import by.paramonov.model.ArgumentEntry;

public interface ArgumentParser {

    String regexForSmashArgs = "-";


    boolean isApplicable(String str);

    <T extends ArgumentEntry> ArgumentEntry parse(String str);
}
