package net.m14m.romannumeralkata;

import java.util.*;

public class RomanNumeralParser {
    private static Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
        put((char) 0, 0);
        put('i', 1);
        put('v', 5);
        put('x', 10);
    }};

    int translate(String input) {
        try {
            return translateUnsafe(input);
        } catch (UnknownCharacterException e) {
            return -1;
        }
    }

    private int translateUnsafe(String input) throws UnknownCharacterException {
        Accumulator accumulator = new Accumulator();
        char[] chars = input.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currChar = chars[i];
            char nextChar = (i+1 == chars.length) ? 0 : chars[i + 1];
            RomanNumeralSymbol currSymbol = valueOf(currChar);
            RomanNumeralSymbol nextSymbol = valueOf(nextChar);
            if (nextSymbol.outranks(currSymbol)) {
                accumulator.value -= currSymbol.value;
            } else {
                accumulator.value += currSymbol.value;
            }
        }
        return accumulator.value;
    }

    private RomanNumeralSymbol valueOf(char c) throws UnknownCharacterException {
        if (!valuesOfLetters.containsKey(c)) throw new UnknownCharacterException();
        return new RomanNumeralSymbol(valuesOfLetters.get(c));
    }

    private static class UnknownCharacterException extends Exception {
    }

    public static class RomanNumeralSymbol {
        public final int value;

        public RomanNumeralSymbol(int value) {
            this.value = value;
        }

        public boolean outranks(RomanNumeralSymbol symbol) {
            return value > symbol.value;
        }
    }
}