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
                RomanNumeral romanNumeral = new RomanNumeral(input).invoke();
                value = romanNumeral.getValue();
                formatter = romanNumeral.getFormatter();
            } else {
                ArabicNumeral arabicNumeral = new ArabicNumeral(input).invoke();
                formatter = arabicNumeral.getFormatter();
                value = arabicNumeral.getValue();
            }
            String displayValue = formatter.format(value);
            output.println(displayValue);
        }
    }

    public class RomanNumeral {
        private String input;
        private int value;
        private Formatter formatter;

        public RomanNumeral(String input) {
            this.input = input;
        }

        public int getValue() {
            return value;
        }

        public Formatter getFormatter() {
            return formatter;
        }

        public RomanNumeral invoke() {
            value = romanNumeralParser.parseValue(input);
            formatter = arabicNumeralFormatter;
            return this;
        }
    }

    public class ArabicNumeral {
        private String input;
        private int value;
        private Formatter formatter;

        public ArabicNumeral(String input) {
            this.input = input;
        }

        public int getValue() {
            return value;
        }

        public Formatter getFormatter() {
            return formatter;
        }

        public ArabicNumeral invoke() {
            value = arabicNumeralParser.parseValue(input);
            formatter = romanNumeralFormatter;
            return this;
        }
    }
}
