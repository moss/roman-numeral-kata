package net.m14m.romannumeralkata;

public class Accumulator {
    private int value = 0;

    public void something(RomanNumeralSymbol currSymbol,
                          RomanNumeralSymbol nextSymbol)
            throws RomanNumeralSymbol.UnrecognizedException {
        if (nextSymbol.outranks(currSymbol)) {
            subtract(currSymbol);
        } else {
            add(currSymbol);
        }
    }

    public void add(RomanNumeralSymbol currSymbol) {
        value += currSymbol.value;
    }

    public void subtract(RomanNumeralSymbol currSymbol) {
        value -= currSymbol.value;
    }

    public int getValue() {
        return value;
    }
}
