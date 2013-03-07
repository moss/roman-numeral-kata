package net.m14m.romannumeralkata;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private StringReader stdin;
    private StringWriter stdout = new StringWriter();

    @Test public void translatesRomanNumeralsToArabic() {
        givenInput("I\n");
        whenIRunTheApp();
        expectOutput("1\n");
    }

    @Test public void translatesNumbersCorrectly() {
        givenInput("III\n");
        whenIRunTheApp();
        expectOutput("3\n");
    }

    private void givenInput(String input) {
        stdin = new StringReader(input);
    }

    private void whenIRunTheApp() {
        new Main(stdin, stdout).execute();
    }

    private void expectOutput(String expectedOutput) {
        assertEquals(expectedOutput, stdout.toString());
    }
}
