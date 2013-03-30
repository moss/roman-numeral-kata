package net.m14m.romannumeralkata;

import java.io.*;

public class Main {
    private final BufferedReader input;
    private final PrintWriter output;
    private final ExpressionParser expressionParser;

    public Main(Reader input, Writer output) {
        this.input = new BufferedReader(input);
        this.output = new PrintWriter(output);
        expressionParser = new ExpressionParser(
                new RomanNumeralParser(),
                new RomanNumeralFormatter(),
                new ArabicNumeralParser(),
                new ArabicNumeralFormatter()
        );
    }

    public void execute() throws IOException {
        String input;
        while ((input = this.input.readLine()) != null) {
            try {
                Expression expression = expressionParser.parse(input);
                String displayValue = expression.getFormatter().format(expression.getValue());
                output.println(displayValue);
            } catch (IllegalExpressionError illegalExpressionError) {
                output.println("ERROR");
            }
        }
    }
}
