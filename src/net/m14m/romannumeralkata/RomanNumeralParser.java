package net.m14m.romannumeralkata;

public class RomanNumeralParser {
    int translate(String input) {
        int value = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c == 'i') value += 1;
            if (c == 'v') value += 5;
            if (c == 'x') value += 10;
        }
        return value;
    }
}