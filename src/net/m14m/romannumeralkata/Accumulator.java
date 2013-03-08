package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.nullSymbol;

public class Accumulator {
    private int value = 0;
    private RomanNumeralSymbol latestSymbol = nullSymbol();

    public void push(RomanNumeralSymbol symbol) {
        something(latestSymbol, symbol);
        latestSymbol = symbol;
    }

    public void something(RomanNumeralSymbol currSymbol, RomanNumeralSymbol nextSymbol) {
        latestSymbol = nextSymbol;
        if (nextSymbol.outranks(currSymbol)) {
            value -= currSymbol.value;
        } else {
            value += currSymbol.value;
        }
    }

    public int getValue() {
        something(latestSymbol, nullSymbol());
        return value;
    }
}
