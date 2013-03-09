package net.m14m.romannumeralkata;

import org.junit.*;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.valueOf;
import static org.junit.Assert.*;

public class RomanNumeralSymbolTest {
    @Test public void biggerNumbersOutrankSmaller() throws RomanNumeralSymbol.UnrecognizedException {
        assertTrue("V > I", valueOf('v').outranks(valueOf('i')));
        assertTrue("X > V", valueOf('x').outranks(valueOf('v')));
        assertTrue("X > I", valueOf('x').outranks(valueOf('i')));
    }

    @Test public void smallerNumbersDoNotOutrankBigger() throws RomanNumeralSymbol.UnrecognizedException {
        assertFalse("V > I", valueOf('i').outranks(valueOf('v')));
        assertFalse("X > V", valueOf('v').outranks(valueOf('x')));
        assertFalse("X > I", valueOf('i').outranks(valueOf('x')));
    }

    @Test public void equalsDoNotOutrankEquals() throws RomanNumeralSymbol.UnrecognizedException {
        assertFalse("I", valueOf('i').outranks(valueOf('i')));
        assertFalse("V", valueOf('v').outranks(valueOf('v')));
        assertFalse("X", valueOf('x').outranks(valueOf('x')));
    }

    @Test public void treatsCapitalsInterchangeablyWithLowercase() throws RomanNumeralSymbol.UnrecognizedException {
        assertEquals(valueOf('i'), valueOf('I'));
    }

    @Test public void toStringIsTheRomanNumeralSymbolInQuestion() throws RomanNumeralSymbol.UnrecognizedException {
        assertEquals("I", valueOf('i').toString());
        assertEquals("V", valueOf('v').toString());
        assertEquals("M", valueOf('m').toString());
    }

    @Test(expected = RomanNumeralSymbol.UnrecognizedException.class)
    public void throwsExceptionForUnrecognizedCharacters()
            throws RomanNumeralSymbol.UnrecognizedException { valueOf('Z');
    }

    @Test public void symbolsAreOnlyEqualToTheSameSymbol() throws RomanNumeralSymbol.UnrecognizedException {
        assertConsistentlyEqual('i', 'i');
        assertConsistentlyEqual('v', 'v');
        assertConsistentlyEqual('x', 'x');
        assertConsistentlyUnequal('i', 'v');
        assertConsistentlyUnequal('v', 'x');
        assertConsistentlyUnequal('x', 'i');
    }

    private void assertConsistentlyEqual(char oneChar, char otherChar) throws RomanNumeralSymbol.UnrecognizedException {
        assertTrue(oneChar + " = " + otherChar, valueOf(oneChar).equals(valueOf(otherChar)));
        assertTrue(otherChar + " = " + oneChar, valueOf(otherChar).equals(valueOf(oneChar)));
        assertTrue(oneChar + " hashcode = " + otherChar + " hashcode",
                valueOf(oneChar).hashCode() == valueOf(otherChar).hashCode());
    }

    private void assertConsistentlyUnequal(char oneChar, char otherChar) throws RomanNumeralSymbol.UnrecognizedException {
        assertFalse(oneChar + " != " + otherChar, valueOf(oneChar).equals(valueOf(otherChar)));
        assertFalse(otherChar + " != " + oneChar, valueOf(otherChar).equals(valueOf(oneChar)));
        assertFalse(oneChar + " hashcode != " + otherChar + " hashcode",
                valueOf(oneChar).hashCode() == valueOf(otherChar).hashCode());
    }
}
