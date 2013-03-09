package net.m14m.romannumeralkata;

import java.io.*;

public class Main {
    private final BufferedReader input;
    private final PrintWriter output;
    private final RomanNumeralParser romanNumeralParser = new RomanNumeralParser();
    private final ArabicNumeralParser arabicNumeralParser = new ArabicNumeralParser();

    public Main(Reader input, Writer output) {
        this.input = new BufferedReader(input);
        this.output = new PrintWriter(output);
    }

    public void execute() throws IOException {
        String input;
        while ((input = this.input.readLine()) != null) {
            if (input.matches("[mdclxviMDCLXVI]+")) {
                output.println(romanNumeralParser.translate(input));
            } else {
                output.println(arabicNumeralParser.translate(input));
            }
        }
    }
}
