package net.m14m.romannumeralkata;

import org.junit.*;

import static net.m14m.romannumeralkata.RomanNumeralSystem.STANDARD;
import static org.junit.Assert.*;

public class RomanNumeralSymbolTest {
    @Test public void biggerNumbersOutrankSmaller() throws UnrecognizedSymbolException {
        assertTrue("V > I", STANDARD.valueOf('v').outranks(STANDARD.valueOf('i')));
        assertTrue("X > V", STANDARD.valueOf('x').outranks(STANDARD.valueOf('v')));
        assertTrue("X > I", STANDARD.valueOf('x').outranks(STANDARD.valueOf('i')));
    }

    @Test public void smallerNumbersDoNotOutrankBigger() throws UnrecognizedSymbolException {
        assertFalse("V > I", STANDARD.valueOf('i').outranks(STANDARD.valueOf('v')));
        assertFalse("X > V", STANDARD.valueOf('v').outranks(STANDARD.valueOf('x')));
        assertFalse("X > I", STANDARD.valueOf('i').outranks(STANDARD.valueOf('x')));
    }

    @Test public void equalsDoNotOutrankEquals() throws UnrecognizedSymbolException {
        assertFalse("I", STANDARD.valueOf('i').outranks(STANDARD.valueOf('i')));
        assertFalse("V", STANDARD.valueOf('v').outranks(STANDARD.valueOf('v')));
        assertFalse("X", STANDARD.valueOf('x').outranks(STANDARD.valueOf('x')));
    }

    @Test public void treatsCapitalsInterchangeablyWithLowercase() throws UnrecognizedSymbolException {
        assertEquals(STANDARD.valueOf('i'), STANDARD.valueOf('I'));
    }

    @Test public void toStringIsTheRomanNumeralSymbolInQuestion() throws UnrecognizedSymbolException {
        assertEquals("I", STANDARD.valueOf('i').toString());
        assertEquals("V", STANDARD.valueOf('v').toString());
        assertEquals("M", STANDARD.valueOf('m').toString());
    }

    @Test(expected = UnrecognizedSymbolException.class)
    public void throwsExceptionForUnrecognizedCharacters()
            throws UnrecognizedSymbolException {
        STANDARD.valueOf('Z');
    }

    @Test public void symbolsAreOnlyEqualToTheSameSymbol() throws UnrecognizedSymbolException {
        assertConsistentlyEqual('i', 'i');
        assertConsistentlyEqual('v', 'v');
        assertConsistentlyEqual('x', 'x');
        assertConsistentlyUnequal('i', 'v');
        assertConsistentlyUnequal('v', 'x');
        assertConsistentlyUnequal('x', 'i');
    }

    private void assertConsistentlyEqual(char oneChar, char otherChar) throws UnrecognizedSymbolException {
        assertTrue(oneChar + " = " + otherChar, STANDARD.valueOf(oneChar)
                .equals(STANDARD.valueOf(otherChar)));
        assertTrue(otherChar + " = " + oneChar, STANDARD.valueOf(otherChar)
                .equals(STANDARD.valueOf(oneChar)));
        assertTrue(oneChar + " hashcode = " + otherChar + " hashcode",
                STANDARD.valueOf(oneChar).hashCode() == STANDARD.valueOf(otherChar).hashCode());
    }

    private void assertConsistentlyUnequal(char oneChar, char otherChar) throws UnrecognizedSymbolException {
        assertFalse(oneChar + " != " + otherChar, STANDARD.valueOf(oneChar)
                .equals(STANDARD.valueOf(otherChar)));
        assertFalse(otherChar + " != " + oneChar, STANDARD.valueOf(otherChar)
                .equals(STANDARD.valueOf(oneChar)));
        assertFalse(oneChar + " hashcode != " + otherChar + " hashcode",
                STANDARD.valueOf(oneChar).hashCode() == STANDARD.valueOf(otherChar).hashCode());
    }
}
