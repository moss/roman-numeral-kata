package net.m14m.romannumeralkata;

public class Accumulator {
    private int value = 0;

    public void add(RomanNumeralParser.RomanNumeralSymbol currSymbol) {
        value += currSymbol.value;
    }

    public void subtract(RomanNumeralParser.RomanNumeralSymbol currSymbol) {
        value -= currSymbol.value;
    }

    public int getValue() {
        return value;
    }
}
