package net.m14m.romannumeralkata;

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
            char currChar = chars[i];
            char nextChar = (i+1 == chars.length) ? 0 : chars[i + 1];
            accumulator.something(valueOf(currChar), valueOf(nextChar));
        }
        return accumulator.getValue();
    }
}