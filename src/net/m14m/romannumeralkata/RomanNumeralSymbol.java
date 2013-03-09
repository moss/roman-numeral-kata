package net.m14m.romannumeralkata;

import java.util.*;

public class RomanNumeralSymbol {
    private static final Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
        put('i', 1);
        put('v', 5);
        put('x', 10);
        put('l', 50);
        put('c', 100);
        put('d', 500);
        put('m', 1000);
    }};

    public final int value;

    public static RomanNumeralSymbol valueOf(char c) throws UnrecognizedException {
        if (!valuesOfLetters.containsKey(c)) throw new UnrecognizedException();
        return new RomanNumeralSymbol(valuesOfLetters.get(c));
    }

    public static RomanNumeralSymbol nullSymbol() {
        return new RomanNumeralSymbol(0);
    }

    private RomanNumeralSymbol(int value) {
        this.value = value;
    }

    public boolean outranks(RomanNumeralSymbol symbol) {
        return value > symbol.value;
    }

    public static class UnrecognizedException extends Exception {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RomanNumeralSymbol)) return false;
        RomanNumeralSymbol that = (RomanNumeralSymbol) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
