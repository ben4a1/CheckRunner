package by.paramonov.service.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.parser.argumentParser.ArgumentParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static by.paramonov.util.TestClass.*;
import static org.junit.jupiter.api.Assertions.*;

class ArgumentServiceImplTest {

    @Mock
    List<ArgumentParser> mockitoArgumentParserList;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void parseInputArgumentsTest() {
        Mockito.when(mockitoArgumentParserList.get(0)).thenReturn(productArgumentParser);
        Mockito.when(mockitoArgumentParserList.get(1)).thenReturn(cardArgumentParser);
        List<ArgumentEntry> expectedArgumentList = new LinkedList<>(List.copyOf(argumentEntryList));
        List<ArgumentEntry> actualArgumentList = new ArgumentServiceImpl(argumentParserList).parseInputArguments(new String[]{productArgument, cardArgument});
        assertEquals(expectedArgumentList, actualArgumentList);
    }
}