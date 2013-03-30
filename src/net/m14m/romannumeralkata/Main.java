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
            Formatter formatter;
            if (input.matches("[mdclxviMDCLXVI]+")) {
                RomanNumeral romanNumeral = new RomanNumeral(arabicNumeralFormatter,
                        romanNumeralParser, input);
                value = romanNumeral.getValue();
                formatter = romanNumeral.getFormatter();
            } else {
                ArabicNumeral arabicNumeral = new ArabicNumeral(input);
                formatter = arabicNumeral.getFormatter();
                value = arabicNumeral.getValue();
            }
            String displayValue = formatter.format(value);
            output.println(displayValue);
        }
    }

    public static class RomanNumeral {
        private String input;
        private Formatter formatter;
        private RomanNumeralParser romanNumeralParser;

        public RomanNumeral(Formatter formatter, RomanNumeralParser romanNumeralParser, String input) {
            this.input = input;
            this.formatter = formatter;
            this.romanNumeralParser = romanNumeralParser;
        }

        public int getValue() {
            return romanNumeralParser.parseValue(input);
        }

        public Formatter getFormatter() {
            return formatter;
        }
    }

    public class ArabicNumeral {
        private String input;

        public ArabicNumeral(String input) {
            this.input = input;
        }

        public int getValue() {
            return arabicNumeralParser.parseValue(input);
        }

        public Formatter getFormatter() {
            return romanNumeralFormatter;
        }
    }
}
