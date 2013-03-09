package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(String input) {
        Integer value = Integer.valueOf(input);
        StringBuilder result = new StringBuilder();
        for (int i=0; i<value; i++) {
            result.append("I");
        }
        return result.toString();
    }
}
