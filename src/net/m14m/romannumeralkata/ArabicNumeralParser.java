package net.m14m.romannumeralkata;

public class ArabicNumeralParser {
    public String translate(Integer value) {
        StringBuilder result = new StringBuilder();
        int i=0;
        while (i < value) {
            if (value == 5) {
                result.append("V");
                break;
            }
            result.append("I");
            i++;
        }
        return result.toString();
    }
}
