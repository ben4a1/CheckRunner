package by.paramonov.parser.impl;

import by.paramonov.model.incomeentries.ArgumentEntry;
import org.junit.jupiter.api.Test;

import static by.paramonov.util.TestClass.*;
import static org.junit.jupiter.api.Assertions.*;

class CardArgumentParserImplTest {

    @Test
    void checkIsApplicableShouldReturnTrue() {
        assertTrue(cardArgumentParser.isApplicable(cardArgument));

    }

    @Test
    void checkIsApplicableShouldReturnFalse(){
        assertFalse(cardArgumentParser.isApplicable(productArgument));
    }

    @Test
    void parse() {
        ArgumentEntry parse = cardArgumentParser.parse(cardArgument);
        assertEquals(cardEntry, parse);
    }
}