package by.paramonov.parser.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import org.junit.jupiter.api.Test;

import static by.paramonov.util.TestClass.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductArgumentParserImplTest {
    @Test
    void isApplicable() {
        assertFalse(productArgumentParser.isApplicable(cardArgument));
        assertTrue(productArgumentParser.isApplicable(productArgument));
    }

    @Test
    void parse() {
        ArgumentEntry parse = productArgumentParser.parse(productArgument);
        assertEquals(productEntry, parse);
    }
}