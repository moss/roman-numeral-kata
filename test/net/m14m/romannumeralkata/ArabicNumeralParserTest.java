package net.m14m.romannumeralkata;

import org.junit.*;

import static org.junit.Assert.*;

public class ArabicNumeralParserTest {
    private ArabicNumeralParser parser = new ArabicNumeralParser();

    @Test public void shouldParseNumbers() {
        assertEquals(4, parser.parseValue("4"));
        assertEquals(15, parser.parseValue("15"));
        assertEquals(2537, parser.parseValue("2537"));
    }
}
