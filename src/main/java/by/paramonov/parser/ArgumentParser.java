package by.paramonov.parser;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.model.DiscountCard;

public interface ArgumentParser {

    String regexForSmashArgs = "-";

    boolean isApplicable(String str);

    ArgumentEntry parse(String str);

}
