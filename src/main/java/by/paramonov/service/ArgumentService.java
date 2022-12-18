package by.paramonov.service;

import by.paramonov.entity.ArgumentEntry;

public class ArgumentService {
    public boolean isApplicable(String str) {
        return false;
    }

    public ArgumentEntry parse(String string){
        return new ArgumentEntry();
    }
}
