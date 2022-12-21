package by.paramonov.parser.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import org.junit.jupiter.api.Test;

import static by.paramonov.util.TestClass.productArgumentParser;
import static by.paramonov.util.TestClass.productEntry;
import static org.junit.jupiter.api.Assertions.*;

class ProductArgumentParserImplTest {
    String notCard = "5-5"; //TODO
    String card = "card-1";
    @Test
    void isApplicable() {
        assertFalse(productArgumentParser.isApplicable(card));
        assertTrue(productArgumentParser.isApplicable(notCard));
    }

    @Test
    void parse() {
        ArgumentEntry parse = productArgumentParser.parse(notCard);
        assertEquals(productEntry, parse);
    }
}