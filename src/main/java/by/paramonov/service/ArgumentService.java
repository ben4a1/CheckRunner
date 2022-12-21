package by.paramonov.service;

import by.paramonov.model.incomeentries.ArgumentEntry;

import java.util.List;

public interface ArgumentService {

    List<ArgumentEntry> parseInputArguments(String[] inputArgs);
}
