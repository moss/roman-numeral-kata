package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i< value; i++) {
            if (value == 5) {
                result.append("V");
                break;
            }
            result.append("I");
        }
        return result.toString();
    }
}
