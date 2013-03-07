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

    @Parameterized.Parameters
    public static List<Object[]> getParameters(){
        Object[][] parameters = {
                {1, "I"},
                {2, "II"},
        };
        return asList(parameters);
    }

    public RomanNumeralParserTest(int expectedValue, String roman) {
        this.expectedValue = expectedValue;
        this.roman = roman;
    }

    @Test public void shouldTranslateRomanNumerals() {
        assertEquals(expectedValue, new RomanNumeralParser().translate(roman));
    }
}
