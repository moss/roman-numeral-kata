package net.m14m.romannumeralkata;

import java.util.*;

public class RomanNumeralParser {
    private static Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
        put('i', 1);
        put('v', 5);
        put('x', 10);
    }};

    int translate(String input) {
        int value = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (!valuesOfLetters.containsKey(c)) return -1;
            value += valuesOfLetters.get(c);
        }
        return value;
    }
}