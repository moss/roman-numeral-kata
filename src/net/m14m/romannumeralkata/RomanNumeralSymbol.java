package net.m14m.romannumeralkata;

import java.util.*;

import static java.util.Arrays.asList;
import static net.m14m.romannumeralkata.RomanNumeralSymbol.RomanNumeralSystem.STANDARD;

public class RomanNumeralSymbol {
    public static class RomanNumeralSystem {
        public static final RomanNumeralSystem STANDARD = new RomanNumeralSystem(
                new RomanNumeralSymbol("M", 1000),
                new RomanNumeralSymbol("D", 500),
                new RomanNumeralSymbol("C", 100),
                new RomanNumeralSymbol("L", 50),
                new RomanNumeralSymbol("X", 10),
                new RomanNumeralSymbol("V", 5),
                new RomanNumeralSymbol("I", 1)
        );
        public final List<RomanNumeralSymbol> symbols;
        private final Map<Character, RomanNumeralSymbol> valuesOfLetters;

        public RomanNumeralSystem(RomanNumeralSymbol... symbols) {
            this.symbols = asList(symbols);
            valuesOfLetters = new HashMap<Character, RomanNumeralSymbol>();
            for (RomanNumeralSymbol symbol : symbols) {
                valuesOfLetters.put(symbol.toChar(), symbol);
            }
        }

        public RomanNumeralSymbol valueOf(char c) throws UnrecognizedSymbolException {
            c = Character.toUpperCase(c);
            if (!valuesOfLetters.containsKey(c)) throw new UnrecognizedSymbolException();
            return valuesOfLetters.get(c);
        }
    }

    public static final List<RomanNumeralSymbol> ALL_SYMBOLS = STANDARD.symbols;

    private final String symbol;
    public final int value;

    public static RomanNumeralSymbol valueOf(char c) throws UnrecognizedSymbolException {
        return STANDARD.valueOf(c);
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

    private Character toChar() {
        return symbol.charAt(0);
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
}
