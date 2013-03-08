package net.m14m.romannumeralkata;

import java.util.*;

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
            RomanNumeralSymbol currSymbol = RomanNumeralSymbol.valueOf(currChar);
            RomanNumeralSymbol nextSymbol = RomanNumeralSymbol.valueOf(nextChar);
            if (nextSymbol.outranks(currSymbol)) {
                accumulator.subtract(currSymbol);
            } else {
                accumulator.add(currSymbol);
            }
        }
        return accumulator.getValue();
    }

    public static class RomanNumeralSymbol {
        private static Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
            put((char) 0, 0);
            put('i', 1);
            put('v', 5);
            put('x', 10);
        }};
        public final int value;

        public static RomanNumeralSymbol valueOf(char c) throws UnrecognizedException {
            if (!valuesOfLetters.containsKey(c)) throw new UnrecognizedException();
            return new RomanNumeralSymbol(valuesOfLetters.get(c));
        }

        public RomanNumeralSymbol(int value) {
            this.value = value;
        }

        public boolean outranks(RomanNumeralSymbol symbol) {
            return value > symbol.value;
        }

        public static class UnrecognizedException extends Exception {
        }
    }
}