package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    private static final Symbol I = new Symbol(1, "I");
    private static final Symbol V = new Symbol(5, "V");
    private static final Symbol X = new Symbol(10, "X");
    private static final Symbol NULL = new Symbol(0, "");

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
        Symbol currentSymbol = NULL;
        if (remainingValue >= X.value) {
            currentSymbol = X;
        } else if (remainingValue >= V.value) {
            currentSymbol = V;
        } else if (remainingValue >= I.value) {
            currentSymbol = I;
        }
        return currentSymbol;
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
