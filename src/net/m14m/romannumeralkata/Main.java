package net.m14m.romannumeralkata;

import java.io.*;

public class Main {
    private final BufferedReader input;
    private final PrintWriter output;
    private final RomanNumeralParser romanNumeralParser = new RomanNumeralParser();
    private final RomanNumeralFormatter romanNumeralFormatter = new RomanNumeralFormatter();
    private final ArabicNumeralParser arabicNumeralParser = new ArabicNumeralParser();

    public Main(Reader input, Writer output) {
        this.input = new BufferedReader(input);
        this.output = new PrintWriter(output);
    }

    public void execute() throws IOException {
        String input;
        while ((input = this.input.readLine()) != null) {
            if (input.matches("[mdclxviMDCLXVI]+")) {
                int value = romanNumeralParser.parseValue(input);
                String displayValue = format(value);
                output.println(displayValue);
            } else {
                int value = arabicNumeralParser.parseValue(input);
                String displayValue = romanNumeralFormatter.format(value);
                output.println(displayValue);
            }
        }
    }

    private String format(int value) {
        return String.valueOf(value);
    }
}
