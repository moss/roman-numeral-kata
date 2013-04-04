package net.m14m.romannumeralkata;

import java.util.regex.*;

public class ExpressionParser {
    private final NumeralParser romanNumeralParser;
    private final Formatter romanNumeralFormatter;
    private final NumeralParser arabicNumeralParser;
    private final Formatter arabicNumeralFormatter;

    public ExpressionParser(RomanNumeralParser romanNumeralParser,
                            RomanNumeralFormatter romanNumeralFormatter,
                            ArabicNumeralParser arabicNumeralParser,
                            ArabicNumeralFormatter arabicNumeralFormatter) {
        this.romanNumeralParser = romanNumeralParser;
        this.romanNumeralFormatter = romanNumeralFormatter;
        this.arabicNumeralParser = arabicNumeralParser;
        this.arabicNumeralFormatter = arabicNumeralFormatter;
    }

    public Expression parse(String input) throws IllegalExpressionError {
        if (input.contains("+")) {
            return parseAddition(input);
        }
        Matcher matcher = Pattern.compile("([mdclxviMDCLXVI]+|\\d+)").matcher(input);
        if (!matcher.matches()) throw new IllegalExpressionError();
        Expression expression;
        if (input.matches("[mdclxviMDCLXVI]+")) {
            expression = new Numeral(arabicNumeralFormatter, romanNumeralParser, input);
        } else {
            expression = new Numeral(romanNumeralFormatter, arabicNumeralParser, input);
        }
        return expression;
    }

    private Expression parseAddition(String input) throws IllegalExpressionError {
        String[] parts = input.split("\\s+\\+\\s+");
        return new Addition(parse(parts[0]), parse(parts[1]));
    }
}