package by.paramonov.parser.impl;

import by.paramonov.model.TypeOfArgument;
import by.paramonov.model.incomeentries.ProductEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @NullSource
    void checkParseShouldReturnException(String toParse){
        Assertions.assertThrows(NullPointerException.class, () -> productArgumentParser.parse(toParse));
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForParametrizedParse")
    void checkParameterizedParseShouldReturnEquals(String toParse, ProductEntry expected){
                assertThat(productArgumentParser.parse(toParse)).isEqualTo(expected);
    }

    static Stream<Arguments> getArgumentsForParametrizedParse(){
        return Stream.of(
                Arguments.of(productArgument, productEntry),
                Arguments.of("15-15", new ProductEntry(TypeOfArgument.PRODUCT, 15, 15))
        );
    }
}