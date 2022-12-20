package by.paramonov.parser.impl;

import by.paramonov.parser.ArgumentParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardArgumentParserImplTest {
    String notCard = "123-15";
    String card = "card-1";
    @BeforeEach
    void setUp(){

    }
    @Test
    void isApplicableTest() {

        ArgumentParser argumentParser = new CardArgumentParserImpl();
        assertTrue(argumentParser.isApplicable(card));
        assertFalse(argumentParser.isApplicable(notCard));
    }

    @Test
    void parse() {

    }
}