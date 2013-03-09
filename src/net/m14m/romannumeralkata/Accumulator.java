package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.nullSymbol;

public class Accumulator {
    private int value = 0;
    private RomanNumeralSymbol latestSymbol = nullSymbol();

    public void push(RomanNumeralSymbol symbol) {
        combineValues(latestSymbol, symbol);
    }

    public int getValue() {
        combineValues(latestSymbol, nullSymbol());
        return value;
    }

    private void combineValues(RomanNumeralSymbol currSymbol, RomanNumeralSymbol nextSymbol) {
        latestSymbol = nextSymbol;
        value += currSymbol.value;
        if (nextSymbol.outranks(currSymbol)) {
            value = -value;
        }
    }
}
