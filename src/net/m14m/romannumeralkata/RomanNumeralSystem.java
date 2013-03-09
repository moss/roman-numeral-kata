package net.m14m.romannumeralkata;

import java.util.*;

import static java.util.Arrays.asList;

public class RomanNumeralSystem {
    public static final RomanNumeralSystem STANDARD = new RomanNumeralSystem(
            new RomanNumeralSymbol("M", 1000),
            new RomanNumeralSymbol("D", 500),
            new RomanNumeralSymbol("C", 100),
            new RomanNumeralSymbol("L", 50),
            new RomanNumeralSymbol("X", 10),
            new RomanNumeralSymbol("V", 5),
            new RomanNumeralSymbol("I", 1)
    );
    public final List<RomanNumeralSymbol> symbols;
    private final Map<Character, RomanNumeralSymbol> valuesOfLetters;

    public RomanNumeralSystem(RomanNumeralSymbol... symbols) {
        this.symbols = asList(symbols);
        valuesOfLetters = new HashMap<Character, RomanNumeralSymbol>();
        for (RomanNumeralSymbol symbol : symbols) {
            valuesOfLetters.put(symbol.toChar(), symbol);
        }
    }

    public RomanNumeralSymbol valueOf(char c) throws UnrecognizedSymbolException {
        c = Character.toUpperCase(c);
        if (!valuesOfLetters.containsKey(c)) throw new UnrecognizedSymbolException();
        return valuesOfLetters.get(c);
    }
}
