package net.m14m.romannumeralkata;

import static net.m14m.romannumeralkata.RomanNumeralSystem.STANDARD;

public class RomanNumeralFormatter implements Formatter {
    public String format(int value) {
        if (value <= 0) return "ERROR";
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            RomanNumeralSymbol symbol = largestRelevantSymbol(remainingValue);
            if (largestRelevantSymbol(remainingValue + 1).outranks(symbol)) {
                result.append("I");
                remainingValue += 1;
            } else {
                result.append(symbol);
                remainingValue -= symbol.value;
            }
        }
        return result.toString();
    }

    private RomanNumeralSymbol largestRelevantSymbol(int remainingValue) {
        for (RomanNumeralSymbol symbol : STANDARD.symbols) {
            if (remainingValue >= symbol.value) return symbol;
        }
        throw new RuntimeException(
                "Programmer error: No symbol was small enough to absorb the remaining value of "
                        + remainingValue);
    }
}
