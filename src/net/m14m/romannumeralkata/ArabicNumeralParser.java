package net.m14m.romannumeralkata;

public class ArabicNumeralParser implements NumeralParser {
    public int parseValue(String input) {
        return Integer.valueOf(input);
    }
}