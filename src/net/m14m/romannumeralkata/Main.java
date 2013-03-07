package net.m14m.romannumeralkata;

import java.io.*;

public class Main {
    private final BufferedReader input;
    private final PrintWriter output;

    public Main(Reader input, Writer output) {
        this.input = new BufferedReader(input);
        this.output = new PrintWriter(output);
    }

    public void execute() throws IOException {
        String input = this.input.readLine();
        output.println(input.length());
    }
}
