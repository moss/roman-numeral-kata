package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RomanNumeralParserTest {
    @Test public void shouldTranslateRomanNumerals() {
        assertEquals(1, new RomanNumeralParser().translate("I"));
    }
}
