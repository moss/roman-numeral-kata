package net.m14m.romannumeralkata;

public class Accumulator {
    private int value = 0;

    public void something(RomanNumeralSymbol currSymbol, RomanNumeralSymbol nextSymbol) {
        if (nextSymbol.outranks(currSymbol)) {
            value -= currSymbol.value;
        } else {
            value += currSymbol.value;
        }
    }

    public int getValue() {
        return value;
    }
}
