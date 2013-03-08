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
            int currValue = valueOf(currChar);
            int nextValue = valueOf(nextChar);
            if (nextValue > currValue) {
                accumulator.value -= currValue;
            } else {
                accumulator.value += currValue;

            }
        }
        return accumulator.value;
    }

    private int valueOf(char c) throws UnknownCharacterException {
        if (!valuesOfLetters.containsKey(c)) throw new UnknownCharacterException();
        return valuesOfLetters.get(c);
    }

    private static class UnknownCharacterException extends Exception {
    }

    public static class Accumulator {
        public int value = 0;
    }
}