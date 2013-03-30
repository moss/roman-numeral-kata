package net.m14m.romannumeralkata;

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

    public Expression parse(String input) {
        Expression expression;
        if (input.matches("[mdclxviMDCLXVI]+")) {
            expression = new Numeral(arabicNumeralFormatter, romanNumeralParser, input);
        } else {
            expression = new Numeral(romanNumeralFormatter, arabicNumeralParser, input);
        }
        return expression;
    }
}