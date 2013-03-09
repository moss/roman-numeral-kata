package net.m14m.romannumeralkata;

public class RomanNumeralSymbol {
    private final String symbol;
    public final int value;

    public static RomanNumeralSymbol nullSymbol() {
        return new RomanNumeralSymbol("", 0);
    }

    public RomanNumeralSymbol(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public boolean outranks(RomanNumeralSymbol symbol) {
        return value > symbol.value;
    }

    public Character toChar() {
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
