package net.m14m.romannumeralkata;

import java.util.*;

import static java.util.Arrays.asList;

public class ArabicNumeralParser {
    private static final List<RomanNumeralSymbol> SYMBOLS = asList(
            new RomanNumeralSymbol("M", 1000),
            new RomanNumeralSymbol("D", 500),
            new RomanNumeralSymbol("C", 100),
            new RomanNumeralSymbol("L", 50),
            new RomanNumeralSymbol("X", 10),
            new RomanNumeralSymbol("V", 5),
            new RomanNumeralSymbol("I", 1)
    );

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
        for (RomanNumeralSymbol symbol : SYMBOLS) {
            if (remainingValue >= symbol.value) return symbol;
        }
        throw new RuntimeException(
                "Programmer error: No symbol was small enough to absorb the remaining value of "
                        + remainingValue);
    }
}
