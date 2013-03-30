package net.m14m.romannumeralkata;

public class Numeral implements Expression {
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
