package by.paramonov.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArgumentEntry {
    private String[] inputArgs;

    public ArgumentEntry() {
    }

    public ArgumentEntry(String[] inputArgs) {
        this.inputArgs = inputArgs;
    }
}
