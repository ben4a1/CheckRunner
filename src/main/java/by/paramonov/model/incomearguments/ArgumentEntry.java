package by.paramonov.model.incomearguments;


import by.paramonov.model.TypeOfArgument;

public abstract class ArgumentEntry  {
    TypeOfArgument typeOfArgument;

    public ArgumentEntry(TypeOfArgument typeOfArgument) {
        this.typeOfArgument = typeOfArgument;
    }
}
