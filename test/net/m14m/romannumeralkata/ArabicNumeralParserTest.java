package net.m14m.romannumeralkata;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArabicNumeralParserTest {
    private final String expectedRoman;
    private final int value;
    private final String message;

    @Parameterized.Parameters
    public static List<Object[]> getParameters() {
        Object[][] parameters = {
                {"I", 1, "I is 1"},
                {"III", 3, "III is 3"},
                {"V", 5, "V is 5"},
        };
        return asList(parameters);
    }

    public ArabicNumeralParserTest(String expectedRoman, int value, String message) {
        this.expectedRoman = expectedRoman;
        this.value = value;
        this.message = message;
    }

    @Test public void shouldTranslateArabicNumerals() {
        assertEquals(message + ": " + value, expectedRoman,
                new ArabicNumeralParser().translate(value));
    }
}
