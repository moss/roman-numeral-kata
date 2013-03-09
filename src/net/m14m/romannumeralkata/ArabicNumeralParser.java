package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    private static final Symbol I = new Symbol(1, "I");
    private static final Symbol V = new Symbol(5, "V");
    private static final Symbol X = new Symbol(10, "X");

    public String translate(Integer value) {
        if (value <= 0) return "ERROR";
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            if (remainingValue >= X.value) {
                result.append(X.symbol);
                remainingValue -= X.value;
            } else if (remainingValue >= V.value) {
                result.append(V.symbol);
                remainingValue -= V.value;
            } else if (remainingValue >= I.value) {
                result.append(I.symbol);
                remainingValue -= I.value;
            }
        }
        return result.toString();
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
