package net.m14m.romannumeralkata;

import java.util.*;

import static java.util.Arrays.asList;

public class ArabicNumeralParser {
    private static final Symbol NULL = new Symbol(0, "");
    private static final List<Symbol> SYMBOLS = asList(
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
            result.append(symbol.symbol);
            remainingValue -= symbol.value;
        }
        return result.toString();
    }

    private Symbol largestRelevantSymbol(int remainingValue) {
        for (Symbol symbol : SYMBOLS) {
            if (remainingValue >= symbol.value) return symbol;
        }
        return NULL;
    }

    private static class Symbol {
        private int value;
        private String symbol;

        private Symbol(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }
}
