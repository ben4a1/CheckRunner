package by.paramonov.model.ext;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.model.TypeOfArgument;

public class CardEntry extends ArgumentEntry {
    private int cardNumber;

    public CardEntry(TypeOfArgument type, int number) {
        super(type);
    }
}
