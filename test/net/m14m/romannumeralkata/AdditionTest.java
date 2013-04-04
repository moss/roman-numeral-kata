package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AdditionTest {
    @Test public void shouldAddUpNumbersCorrectly() {
        Addition addition = new Addition(Constant.arabic(1), Constant.arabic(3));
        assertEquals(4, addition.getValue());
    }

    @Test public void shouldUseTheFormatOfTheFirstExpressionInTheAddition() {
        Addition romanAddition = new Addition(Constant.roman(1), Constant.arabic(3));
        Addition arabicAddition = new Addition(Constant.arabic(1), Constant.arabic(3));
        assertEquals("V", romanAddition.getFormatter().format(5));
        assertEquals("5", arabicAddition.getFormatter().format(5));
    }

    public static class Constant implements Expression {
        private final int value;
        private final Formatter formatter;

        public static Expression arabic(final int value) {
            return new Constant(value, new ArabicNumeralFormatter());
        }

        public static Expression roman(int value) {
            return new Constant(value, new RomanNumeralFormatter());
        }

        public Constant(int value, Formatter formatter) {
            this.value = value;
            this.formatter = formatter;
        }

        public int getValue() {
            return value;
        }

        public Formatter getFormatter() {
            return formatter;
        }
    }
}
