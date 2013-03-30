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
            Numeral numeral;
            if (input.matches("[mdclxviMDCLXVI]+")) {
                numeral = new Numeral(arabicNumeralFormatter, romanNumeralParser, input);
            } else {
                numeral = new Numeral(romanNumeralFormatter, arabicNumeralParser, input);
            }
            String displayValue = numeral.getFormatter().format(numeral.getValue());
            output.println(displayValue);
        }
    }

    public static class Numeral {
        private String input;
        private Formatter formatter;
        private NumeralParser parser;

        public Numeral(Formatter formatter, NumeralParser parser, String input) {
            this.input = input;
            this.formatter = formatter;
            this.parser = parser;
        }

        public int getValue() {
            return parser.parseValue(input);
        }

        public Formatter getFormatter() {
            return formatter;
        }
    }
}
