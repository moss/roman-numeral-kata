package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AdditionTest {
    @Test public void shouldAddUpNumbersCorrectly() {
        Addition addition = new Addition(Constant.arabic(1), Constant.arabic(3));
        assertEquals(4, addition.getValue());
    }

    public static class Constant implements Expression {
        private final int value;
        private ArabicNumeralFormatter formatter;

        public static Expression arabic(final int value) {
            return new Constant(value, new ArabicNumeralFormatter());
        }

        public Constant(int value, ArabicNumeralFormatter formatter) {
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
