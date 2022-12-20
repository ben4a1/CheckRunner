package by.paramonov.parser.impl;

import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.CardEntry;
import by.paramonov.parser.ArgumentParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardArgumentParserImplTest {
    String notCard = "123-15";
    String card = "card-1";
    ArgumentEntry cardEntry = new CardEntry(TypeOfArgument.CARD, 1);
    ArgumentParser argumentParser = new CardArgumentParserImpl();

    @Test
    void isApplicableTest() {
        assertTrue(argumentParser.isApplicable(card));
        assertFalse(argumentParser.isApplicable(notCard));
    }

    @Test
    void parse() {
        ArgumentEntry parse = argumentParser.parse(card);
        assertEquals(cardEntry, parse);
    }
}