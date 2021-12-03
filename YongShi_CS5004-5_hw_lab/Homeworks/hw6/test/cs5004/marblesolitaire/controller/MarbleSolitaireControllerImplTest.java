package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class MarbleSolitaireControllerImplTest {
    @Test
    public void playGameTest1() throws IOException {
        runTest("q", "Current moveCount is 0. Game ongoing...\n" +
                "pls press \"q\" to quit; or any other key to continue:\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    _ _ _ |b\n" +
                "    _ _ _ |b\n" +
                "_ _ _ _ _ _ _ |b\n" +
                "_ o o _ _ _ _ |b\n" +
                "_ _ _ _ _ _ _ |b\n" +
                "    _ _ _ |b\n" +
                "    _ _ o |b\n" +
                "Score:3");
    }

    @Test
    public void playGameTest2() throws IOException {
        runTest("c q", "Current moveCount is 0. Game ongoing...\n" +
                "pls press \"q\" to quit; or any other key to continue:c\n" +
                "pls input from x(1 is the first row) or \"q\" to quit:q\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    _ _ _ |b\n" +
                "    _ _ _ |b\n" +
                "_ _ _ _ _ _ _ |b\n" +
                "_ o o _ _ _ _ |b\n" +
                "_ _ _ _ _ _ _ |b\n" +
                "    _ _ _ |b\n" +
                "    _ _ o |b\n" +
                "Score:3\n" +
                "Process finished with exit code 99");
    }

    @Test
    public void playGameTest3() throws IOException {
        runTest("c 4 2 4 4", "Current moveCount is 0. Game ongoing...\n" +
                "pls press \"q\" to quit; or any other key to continue:" +
                "pls input from x(1 is the first row) or \"q\" to quit:" +
                "pls input from Y(1 is the first col) or \"q\" to quit:" +
                "pls input to x(1 is the first row) or \"q\" to quit:" +
                "pls input to Y(1 is the first col) or \"q\" to quit:" +
                "Game Over!\n" +
                "    _ _ _ |b\n" +
                "    _ _ _ |b\n" +
                "_ _ _ _ _ _ _ |b\n" +
                "_ _ o _ _ _ _ |b\n" +
                "_ _ _ _ _ _ _ |b\n" +
                "    _ _ _ |b\n" +
                "    _ _ o |b\n" +
                "Score:2\n" +
                "Process finished with exit code 99");
    }

    public void runTest(String input, String output) throws IOException {
        Reader in = new StringReader(input);
        StringBuilder out = new StringBuilder();
        MarbleSolitaireController ctrl =
                new MarbleSolitaireControllerImpl(in, out);
        ctrl.playGame(new MarbleSolitaireModelImpl());
        assertEquals(output, out.toString());
    }
}