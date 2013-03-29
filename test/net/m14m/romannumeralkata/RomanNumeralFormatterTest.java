package net.m14m.romannumeralkata;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RomanNumeralFormatterTest {
    private final String expectedRoman;
    private final int value;
    private final String message;

    @Parameterized.Parameters
    public static List<Object[]> getParameters() {
        Object[][] parameters = {
                {"ERROR", 0, "0 is forbidden"},
                {"ERROR", -1, "negatives are forbidden"},
                {"I", 1, "I is 1"},
                {"III", 3, "III is 3"},
                {"V", 5, "V is 5"},
                {"VI", 6, "VI is 6"},
                {"VII", 7, "VII is 7"},
                {"XI", 11, "XI is 11"},
                {"LXVI", 66, "LXVI is 66"},
                {"MDCLXVI", 1666, "MDCLXVI is 1666 (all recognized symbols)"},
                {"IX", 9, "9 should be IX, not VIIII"},
                {"IM", 999, "999 should be IM, not DCCCCLXXXXVIIII"},
        };
        return asList(parameters);
    }

    public RomanNumeralFormatterTest(String expectedRoman, int value, String message) {
        this.expectedRoman = expectedRoman;
        this.value = value;
        this.message = message;
    }

    @Test public void shouldTranslateArabicNumerals() {
        assertEquals(message + ": " + value, expectedRoman,
                new RomanNumeralFormatter().format(value));
    }
}
