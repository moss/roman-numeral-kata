package net.m14m.romannumeralkata;

import java.io.*;

public class Main {
    private final BufferedReader input;
    private final PrintWriter output;
    private final NumeralParser romanNumeralParser = new RomanNumeralParser();
    private final Formatter romanNumeralFormatter = new RomanNumeralFormatter();
    private final NumeralParser arabicNumeralParser = new ArabicNumeralParser();
    private final Formatter arabicNumeralFormatter = new ArabicNumeralFormatter();

    public Main(Reader input, Writer output) {
        this.input = new BufferedReader(input);
        this.output = new PrintWriter(output);
    }

    public void execute() throws IOException {
        String input;
        while ((input = this.input.readLine()) != null) {
            Expression expression = parse(input);
            String displayValue = expression.getFormatter().format(expression.getValue());
            output.println(displayValue);
        }
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
