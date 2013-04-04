package net.m14m.romannumeralkata;

public class Addition implements Expression {
    private final Expression first;
    private final Expression second;

    public Addition(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    public int getValue() {
        return first.getValue() + second.getValue();
    }

    public Formatter getFormatter() {
        return second.getFormatter();
    }
}
