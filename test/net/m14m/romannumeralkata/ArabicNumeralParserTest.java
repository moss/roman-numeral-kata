package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.*;

public class ArabicNumeralParserTest {
    @Test public void shouldParseNumbers() {
        assertEquals(4, new ArabicNumeralParser().parseValue("4"));
        assertEquals(15, new ArabicNumeralParser().parseValue("15"));
        assertEquals(2537, new ArabicNumeralParser().parseValue("2537"));
    }
}
