package net.m14m.romannumeralkata;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private StringReader stdin;
    private StringWriter stdout = new StringWriter();

    @Test public void translatesRomanNumeralsToArabic() throws IOException {
        givenInput("I\n");
        whenIRunTheApp();
        expectOutput("1\n");
    }

    @Test public void translatesNumbersCorrectly() throws IOException {
        givenInput("III\n");
        whenIRunTheApp();
        expectOutput("3\n");
    }

    @Test public void readsAsMuchInputAsYouHave() throws IOException {
        givenInput("II\nI\n");
        whenIRunTheApp();
        expectOutput("2\n1\n");
    }

    @Test public void translatesArabicNumeralsIntoRoman() throws IOException {
        givenInput("1\n");
        whenIRunTheApp();
        expectOutput("I\n");
    }

    @Test public void translatesArabicNumeralsIntoRomanCorrectly() throws IOException {
        givenInput("3\n");
        whenIRunTheApp();
        expectOutput("III\n");
    }

    @Ignore @Test public void addsTwoRomanNumeralsAndDisplaysTheResultAsARomanNumeral() throws IOException {
        givenInput("II + III");
        whenIRunTheApp();
        expectOutput("V");
    }

    private void givenInput(String input) {
        stdin = new StringReader(input);
    }

    private void whenIRunTheApp() throws IOException {
        new Main(stdin, stdout).execute();
    }

    private void expectOutput(String expectedOutput) {
        assertEquals(expectedOutput, stdout.toString());
    }
}
