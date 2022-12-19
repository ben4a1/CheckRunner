package by.paramonov.model;

import lombok.Getter;
import lombok.Setter;


public abstract class ArgumentEntry  {
    TypeOfArgument typeOfArgument;

    public ArgumentEntry(TypeOfArgument typeOfArgument) {
        this.typeOfArgument = typeOfArgument;
    }
}
