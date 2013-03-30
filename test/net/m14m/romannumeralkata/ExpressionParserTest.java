package net.m14m.romannumeralkata;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExpressionParserTest {
    private ExpressionParser parser = new ExpressionParser(
            new RomanNumeralParser(), new RomanNumeralFormatter(),
            new ArabicNumeralParser(), new ArabicNumeralFormatter()
    );

    @Test public void shouldParseRomanNumeralExpressions() throws IllegalExpressionError {
        assertThat(parser.parse("iii").getValue(), is(3));
        assertThat(parser.parse("IX").getValue(), is(9));
    }

    @Test public void shouldParseArabicNumeralExpressions() throws IllegalExpressionError {
        assertThat(parser.parse("3").getValue(), is(3));
        assertThat(parser.parse("9").getValue(), is(9));
    }

    @Test(expected = IllegalExpressionError.class)
    public void shouldDisallowBadExpressions() throws IllegalExpressionError {
        parser.parse("abc");
    }
}
