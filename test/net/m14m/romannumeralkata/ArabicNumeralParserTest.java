package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ArabicNumeralParserTest {
    @Test public void shouldTranslateArabicNumerals() {
        assertEquals("I is 1: 1", "I", new ArabicNumeralParser().translate(1));
    }
}
