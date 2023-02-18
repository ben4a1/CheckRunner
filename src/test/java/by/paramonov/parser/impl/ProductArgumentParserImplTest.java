package by.paramonov.parser.impl;

import org.junit.jupiter.api.Test;

import static by.paramonov.util.TestClass.*;
import static org.assertj.core.api.Assertions.*;

class ProductArgumentParserImplTest {
    @Test
    void checkIsApplicableShouldReturnTrue() {
        assertThat(productArgumentParser.isApplicable(productArgument)).isTrue();
    }

    @Test
    void checkIsApplicableShouldReturnFalse() {
        assertThat(productArgumentParser.isApplicable(cardArgument)).isFalse();
    }
    @Test
    void checkParseShouldReturnEquals() {
        assertThat(productEntry).isEqualTo(productArgumentParser.parse(productArgument));
    }
}