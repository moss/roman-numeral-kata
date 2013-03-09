package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        if (value <= 0) return "ERROR";
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            RomanNumeralSymbol symbol = largestRelevantSymbol(remainingValue);
            result.append(symbol);
            remainingValue -= symbol.value;
        }
        return result.toString();
    }

    private RomanNumeralSymbol largestRelevantSymbol(int remainingValue) {
        for (RomanNumeralSymbol symbol : RomanNumeralSymbol.ALL_SYMBOLS) {
            if (remainingValue >= symbol.value) return symbol;
        }
        throw new RuntimeException(
                "Programmer error: No symbol was small enough to absorb the remaining value of "
                        + remainingValue);
    }
}
