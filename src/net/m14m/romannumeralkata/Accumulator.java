package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.nullSymbol;

public class Accumulator {
    private int value = 0;
    private RomanNumeralSymbol latestSymbol = nullSymbol();

    public void push(RomanNumeralSymbol symbol) {
        value += latestSymbol.value;
        if (symbol.outranks(latestSymbol)) {
            value = -value;
        }
        latestSymbol = symbol;
    }

    public int getValue() {
        push(nullSymbol());
        return value;
    }
}
