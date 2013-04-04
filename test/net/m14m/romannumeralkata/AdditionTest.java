package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AdditionTest {
    @Test public void shouldAddUpNumbersCorrectly() {
        Addition addition = new Addition(arabicConstant(1), arabicConstant(3));
        assertEquals(4, addition.getValue());
    }

    private Expression arabicConstant(final int value) {
        return new Expression() {
            public int getValue() {
                return value;
            }

            public Formatter getFormatter() {
                return new ArabicNumeralFormatter();
            }
        };
    }
}
