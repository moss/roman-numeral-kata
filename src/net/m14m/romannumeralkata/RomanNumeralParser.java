package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSystem.STANDARD;

public class RomanNumeralParser {
    int parseValue(String input) {
        try {
            return translateUnsafe(input);
        } catch (UnrecognizedSymbolException e) {
            return -1;
        }
    }

    private int translateUnsafe(String input) throws UnrecognizedSymbolException {
        Accumulator accumulator = new Accumulator();
        char[] chars = input.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            accumulator.push(STANDARD.valueOf(chars[i]));
        }
        return accumulator.getValue();
    }
}