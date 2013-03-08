package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.nullSymbol;
import static net.m14m.romannumeralkata.RomanNumeralSymbol.valueOf;

public class RomanNumeralParser {
    int translate(String input) {
        try {
            return translateUnsafe(input);
        } catch (RomanNumeralSymbol.UnrecognizedException e) {
            return -1;
        }
    }

    private int translateUnsafe(String input) throws RomanNumeralSymbol.UnrecognizedException {
        Accumulator accumulator = new Accumulator();
        char[] chars = input.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            RomanNumeralSymbol currChar = valueOf(chars[i]);
            RomanNumeralSymbol nextChar = (i + 1 == chars.length) ? nullSymbol() : valueOf(chars[i + 1]);
            accumulator.something(currChar, nextChar);
        }
        return accumulator.getValue();
    }
}