package by.paramonov.model.incomeentries;

import by.paramonov.model.TypeOfArgument;
import lombok.Getter;

import java.util.Objects;

public class CardEntry extends ArgumentEntry {
    @Getter
    private final int cardNumber;

    public CardEntry(TypeOfArgument type, int number) {
        super(type);
        this.cardNumber = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardEntry cardEntry)) return false;
        return cardNumber == cardEntry.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }
}
