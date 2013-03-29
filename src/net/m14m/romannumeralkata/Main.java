package net.m14m.romannumeralkata;

import java.io.*;

public class Main {
    private final BufferedReader input;
    private final PrintWriter output;
    private final RomanNumeralParser romanNumeralParser = new RomanNumeralParser();
    private final Formatter romanNumeralFormatter = new RomanNumeralFormatter();
    private final ArabicNumeralParser arabicNumeralParser = new ArabicNumeralParser();
    private final Formatter arabicNumeralFormatter = new ArabicNumeralFormatter();

    public Main(Reader input, Writer output) {
        this.input = new BufferedReader(input);
        this.output = new PrintWriter(output);
    }

    public void execute() throws IOException {
        String input;
        while ((input = this.input.readLine()) != null) {
            int value;
            if (input.matches("[mdclxviMDCLXVI]+")) {
                value = romanNumeralParser.parseValue(input);
                String displayValue = arabicNumeralFormatter.format(value);
                output.println(displayValue);
            } else {
                value = arabicNumeralParser.parseValue(input);
                String displayValue = romanNumeralFormatter.format(value);
                output.println(displayValue);
            }
        }
    }
}
