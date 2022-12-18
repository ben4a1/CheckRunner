package by.paramonov.parser;

import by.paramonov.entity.ArgumentEntry;

public interface ArgumentParser {

    String regexForSmashArgs = "-";

    boolean isApplicable(String str);

}
