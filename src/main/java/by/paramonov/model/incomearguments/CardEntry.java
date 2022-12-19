package by.paramonov.model.incomearguments;

import by.paramonov.model.TypeOfArgument;
import lombok.Getter;

public class CardEntry extends ArgumentEntry {
    @Getter
    private final int cardNumber;

    public CardEntry(TypeOfArgument type, int number) {
        super(type);
        this.cardNumber = number;
    }
}
