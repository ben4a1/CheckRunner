package by.paramonov.parser.impl;

import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.model.incomeentries.ProductEntry;
import by.paramonov.parser.ArgumentParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductArgumentParserImplTest {
    String notCard = "5-5";
    String card = "card-1";
    ArgumentEntry productEntry = new ProductEntry(TypeOfArgument.PRODUCT, 5, 5);
    ArgumentParser argumentParser = new ProductArgumentParserImpl();
    @Test
    void isApplicable() {
        assertFalse(argumentParser.isApplicable(card));
        assertTrue(argumentParser.isApplicable(notCard));
    }

    @Test
    void parse() {
        ArgumentEntry parse = argumentParser.parse(notCard);
        assertEquals(productEntry, parse);
    }
}