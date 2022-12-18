package by.paramonov.parser;

import by.paramonov.entity.ArgumentEntry;
import by.paramonov.model.DiscountCard;

public interface ArgumentParser {

    String regexForSmashArgs = "-";

    boolean isApplicable(String str);

    ArgumentEntry parseProduct(String str);

    DiscountCard parseCard(String str);
}
