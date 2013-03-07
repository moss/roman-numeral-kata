package net.m14m.romannumeralkata;

public class RomanNumeralParser {
    int translate(String input) {
        int value = 0;
        for (char c : input.toCharArray()) {
            if (c == 'I') value += 1;
            if (c == 'V') value += 5;
        }
        return value;
    }
}