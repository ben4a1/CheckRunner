package by.paramonov.service.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.parser.argumentParser.ArgumentParser;
import by.paramonov.service.ArgumentService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArgumentServiceImpl implements ArgumentService {
    private final List<ArgumentParser> argumentParserList;


    public ArgumentServiceImpl(List<ArgumentParser> argumentParserList) {
        this.argumentParserList = argumentParserList;
    }

    @Override
    public List<ArgumentEntry> parseInputArguments(String[] inputArgs) {
        List<ArgumentEntry> argumentEntryList = new LinkedList<>();
        Arrays.stream(inputArgs).forEach(argument ->
                argumentParserList.forEach(parser -> {
                    if (parser.isApplicable(argument)) {
                        argumentEntryList.add(parser.parse(argument));
                    }
                }));
        return argumentEntryList;
    }

}
