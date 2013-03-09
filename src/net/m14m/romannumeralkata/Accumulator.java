package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.nullSymbol;

public class Accumulator {
    private int value = 0;
    private RomanNumeralSymbol latestSymbol = nullSymbol();

    public void push(RomanNumeralSymbol symbol) {
        combineValues(symbol);
    }

    public int getValue() {
        combineValues(nullSymbol());
        return value;
    }

    private void combineValues(RomanNumeralSymbol nextSymbol) {
        value += latestSymbol.value;
        if (nextSymbol.outranks(latestSymbol)) {
            value = -value;
        }
        latestSymbol = nextSymbol;
    }
}
