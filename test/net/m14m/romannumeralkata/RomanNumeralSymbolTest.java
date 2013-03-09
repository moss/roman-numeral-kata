package net.m14m.romannumeralkata;

import org.junit.*;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.valueOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
