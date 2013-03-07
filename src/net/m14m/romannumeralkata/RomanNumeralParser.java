package net.m14m.romannumeralkata;

import java.util.*;

public class RomanNumeralParser {
    private static Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
        put('i', 1);
        put('v', 5);
        put('x', 10);
    }};

    int translate(String input) {
        try {
            return translateUnsafe(input);
        } catch (NullPointerException e) {
            return -1;
        }
    }

    private int translateUnsafe(String input) {
        int value = 0;
        char[] chars = input.toLowerCase().toCharArray();
        int prevValue = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int charValue = valuesOfLetters.get(c);
            if (charValue > prevValue) value -= (prevValue * 2);
            value += charValue;
            prevValue = charValue;
        }
        return value;
    }
}