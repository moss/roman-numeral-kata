package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ArabicNumeralFormatterTest {
    private ArabicNumeralFormatter formatter = new ArabicNumeralFormatter();

    @Test public void shouldFormatNumbers() {
        assertEquals("4", formatter.format(4));
        assertEquals("83", formatter.format(83));
        assertEquals("1987", formatter.format(1987));
    }
}
