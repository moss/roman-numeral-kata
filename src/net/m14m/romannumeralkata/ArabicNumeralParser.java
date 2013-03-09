package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            if (remainingValue >= 5) {
                result.append("V");
                remainingValue -= 5;
            } else {
                result.append("I");
                remainingValue -= 1;
            }
        }
        return result.toString();
    }
}
