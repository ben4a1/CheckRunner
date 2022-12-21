package by.paramonov.service;

import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.parser.ArgumentParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArgumentServiceImpl {

    List<ArgumentParser> argumentParserList;

    public ArgumentServiceImpl(@Qualifier("cardArgumentParserImpl") ArgumentParser cardArgument, @Qualifier("productArgumentParserImpl") ArgumentParser productParser) {
        argumentParserList = new ArrayList<>();
        argumentParserList.add(cardArgument);
        argumentParserList.add(productParser);
    }

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
