package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            if (value == 5) {
                result.append("V");
                break;
            }
            result.append("I");
            remainingValue--;
        }
        return result.toString();
    }
}
