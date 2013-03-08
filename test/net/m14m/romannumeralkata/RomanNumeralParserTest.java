package net.m14m.romannumeralkata;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RomanNumeralParserTest {
    private int expectedValue;
    private String roman;
    private final String message;

    @Parameterized.Parameters
    public static List<Object[]> getParameters() {
        Object[][] parameters = {
                {1, "I", "I is 1"},
                {2, "II", "multiples add up"},
                {5, "V", "V is 5"},
                {6, "VI", "combining letters"},
                {6, "vi", "lowercase"},
                {10, "X", "X is 10"},
                {11, "XI", "adding on to X"},
                {-1, "foo", "errors become -1"},
                {4, "IV", "lower value before higher value subtracts"},
                {9, "IX", "lower value before higher value subtracts"},
//                {8, "IIX", "multiple lower values in a row"},
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
                new RomanNumeralParser().translate(roman));
    }
}
