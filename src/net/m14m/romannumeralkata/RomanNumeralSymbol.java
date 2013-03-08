package net.m14m.romannumeralkata;

import java.util.*;

public class RomanNumeralSymbol {
    private static final Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
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

    private RomanNumeralSymbol(int value) {
        this.value = value;
    }

    public boolean outranks(RomanNumeralSymbol symbol) {
        return value > symbol.value;
    }

    public static class UnrecognizedException extends Exception {
    }
}
