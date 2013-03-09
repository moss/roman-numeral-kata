package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i< value; i++) {
            result.append("I");
        }
        return result.toString();
    }
}
