package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSymbol.nullSymbol;

public class Accumulator {
    private int value = 0;
    private int groupValue = 0;
    private RomanNumeralSymbol latestSymbol = nullSymbol();

    public void push(RomanNumeralSymbol symbol) {
        groupValue += latestSymbol.value;
        if (symbol.outranks(latestSymbol)) {
            value -= groupValue;
            groupValue = 0;
        } else if (latestSymbol.outranks(symbol)) {
            value += groupValue;
            groupValue = 0;
        }
        latestSymbol = symbol;
    }

    public int getValue() {
        push(nullSymbol());
        return value;
    }
}
