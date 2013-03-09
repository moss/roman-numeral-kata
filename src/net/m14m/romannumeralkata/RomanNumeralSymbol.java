package net.m14m.romannumeralkata;

import java.util.*;

import static java.util.Arrays.asList;

public class RomanNumeralSymbol {
    public static final List<RomanNumeralSymbol> ALL_SYMBOLS = asList(
            new RomanNumeralSymbol("M", 1000),
            new RomanNumeralSymbol("D", 500),
            new RomanNumeralSymbol("C", 100),
            new RomanNumeralSymbol("L", 50),
            new RomanNumeralSymbol("X", 10),
            new RomanNumeralSymbol("V", 5),
            new RomanNumeralSymbol("I", 1)
    );
    private static final Map<Character, Integer> valuesOfLetters = new HashMap<Character, Integer>() {{
        put('i', 1);
        put('v', 5);
        put('x', 10);
        put('l', 50);
        put('c', 100);
        put('d', 500);
        put('m', 1000);
    }};

    private final String symbol;
    public final int value;

    public static RomanNumeralSymbol valueOf(char c) throws UnrecognizedException {
        c = Character.toLowerCase(c);
        if (!valuesOfLetters.containsKey(c)) throw new UnrecognizedException();
        return new RomanNumeralSymbol(Character.toString(c).toUpperCase(), valuesOfLetters.get(c));
    }

    public static RomanNumeralSymbol nullSymbol() {
        return new RomanNumeralSymbol("", 0);
    }

    private RomanNumeralSymbol(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public boolean outranks(RomanNumeralSymbol symbol) {
        return value > symbol.value;
    }

    @Override public String toString() {
        return symbol;
    }

    @Override public boolean equals(Object that) {
        if (!(that instanceof RomanNumeralSymbol)) return false;
        return this.value == ((RomanNumeralSymbol) that).value;
    }

    @Override public int hashCode() {
        return value;
    }

    public static class UnrecognizedException extends Exception {
    }
}
