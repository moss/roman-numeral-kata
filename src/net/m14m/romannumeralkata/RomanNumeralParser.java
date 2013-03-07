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
        int value = 0;
        char[] chars = input.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char prevChar = i == 0 ? 0 : chars[i - 1];
            char curChar = chars[i];
            int prevValue = valueOf(prevChar);
            int charValue = valueOf(curChar);
            if (charValue > prevValue) value -= (prevValue * 2);
            value += charValue;
            prevValue = charValue;
        }
        return value;
    }

    private int valueOf(char c) throws UnknownCharacterException {
        if (!valuesOfLetters.containsKey(c)) throw new UnknownCharacterException();
        return valuesOfLetters.get(c);
    }

    private static class UnknownCharacterException extends Exception {
    }
}