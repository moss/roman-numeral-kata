package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        if (value <= 0) return "ERROR";
        StringBuilder result = new StringBuilder();
        int remainingValue = value;
        while (remainingValue > 0) {
            if (remainingValue >= 10) {
                result.append("X");
                remainingValue -= 10;
            } else if (remainingValue >= 5) {
                result.append("V");
                remainingValue -= 5;
            } else if (remainingValue >= 1) {
                result.append("I");
                remainingValue -= 1;
            }
        }
        return result.toString();
    }
}
