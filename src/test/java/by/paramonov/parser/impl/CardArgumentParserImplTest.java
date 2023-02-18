package by.paramonov.parser.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static by.paramonov.util.TestClass.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CardArgumentParserImplTest {

    @Test
    void checkIsApplicableShouldReturnTrue() {
        assertTrue(cardArgumentParser.isApplicable(cardArgument));

    }

    @Test
    void checkIsApplicableShouldReturnFalse() {
        assertFalse(cardArgumentParser.isApplicable(productArgument));
    }

    @Test
    void checkParseShouldReturnEquals() {
        assertThat(cardEntry).isEqualTo(cardArgumentParser.parse(cardArgument));
    }
}