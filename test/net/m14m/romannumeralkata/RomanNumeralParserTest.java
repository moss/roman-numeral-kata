package net.m14m.romannumeralkata;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RomanNumeralParserTest {
    private final int expectedValue;
    private final String roman;
    private final String message;

    @Parameterized.Parameters
    public static List<Object[]> getParameters() {
        Object[][] parameters = {
                {-1, "foo", "errors become -1"},
                {1, "I", "I is 1"},
                {2, "II", "multiples add up"},
                {3, "III", "more multiples add up"},
                {4, "IV", "lower value before higher value subtracts"},
                {4, "IIII", "supersticious four"},
                {5, "V", "V is 5"},
                {6, "VI", "combining letters"},
                {6, "vi", "lowercase"},
                {8, "IIX", "multiple lower values in a row"},
                {9, "IX", "lower value before higher value subtracts"},
                {10, "X", "X is 10"},
                {11, "XI", "adding on to X"},
                {14, "XIV", "alternating higher and lower values"},
                {19, "XIX", "same symbol in different roles"},
                {28, "XXVIII", "longer numbers"},
                {50, "L", "L"},
                {51, "LI", "LI"},
                {100, "C", "C"},
                {101, "CI", "CI"},
                {500, "D", "D"},
                {501, "DI", "DI"},
                {1000, "M", "M"},
                {1001, "MI", "MI"},
        };
        return asList(parameters);
    }

    public RomanNumeralParserTest(int expectedValue, String roman, String message) {
        this.expectedValue = expectedValue;
        this.roman = roman;
        this.message = message;
    }

    @Test public void shouldTranslateRomanNumerals() {
        assertEquals(message + ": " + roman, expectedValue,
                new RomanNumeralParser().parseValue(roman));
    }
}
