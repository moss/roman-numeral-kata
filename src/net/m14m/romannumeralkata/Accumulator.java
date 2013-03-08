package net.m14m.romannumeralkata;

public class Accumulator {
    public int value = 0;

    void add(RomanNumeralParser.RomanNumeralSymbol currSymbol) {
        value += currSymbol.value;
    }

    void subtract(RomanNumeralParser.RomanNumeralSymbol currSymbol) {
        value -= currSymbol.value;
    }
}
