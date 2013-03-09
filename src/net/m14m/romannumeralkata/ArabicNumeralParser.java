package net.m14m.romannumeralkata;

import java.util.*;

import static java.util.Arrays.asList;

public class ArabicNumeralParser {
    private static final List<Symbol> SYMBOLS = asList(
            new Symbol(1000, "M"),
            new Symbol(500, "D"),
            new Symbol(100, "C"),
            new Symbol(50, "L"),
            new Symbol(10, "X"),
            new Symbol(5, "V"),
            new Symbol(1, "I")
    );

    public String translate(Integer value) {
        if (value <= 0) return "ERROR";
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            Symbol symbol = largestRelevantSymbol(remainingValue);
            result.append(symbol);
            remainingValue -= symbol.value;
        }
        return result.toString();
    }

    private Symbol largestRelevantSymbol(int remainingValue) {
        for (Symbol symbol : SYMBOLS) {
            if (remainingValue >= symbol.value) return symbol;
        }
        throw new RuntimeException(
                "Programmer error: No symbol was small enough to absorb the remaining value of "
                        + remainingValue);
    }

    private static class Symbol {
        private final int value;
        private final String symbol;

        private Symbol(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        public String toString() {
            return symbol;
        }
    }
}
