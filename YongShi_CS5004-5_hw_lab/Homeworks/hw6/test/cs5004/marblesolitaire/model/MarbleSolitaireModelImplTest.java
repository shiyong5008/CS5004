package cs5004.marblesolitaire.model;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class MarbleSolitaireModelImplTest {

    // timeout rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(15);
    // 15s max

    @Test
    public void g1TestMarbleSolitaireModelImpl() {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        assertEquals(
                "    o o o \b\n"+
                        "    o o o \b\n"+
                        "o o o o _ o o \b\n"+
                        "o o o o o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "    o o o \b\n"+
                        "    o o o \b", g1.toString());
    }

    @Test
    public void g1TestMove() {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        g1.move(2,2, 2, 4);
        assertEquals(
                "    o o o \b\n"+
                        "    o o o \b\n"+
                        "o o _ _ o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "    o o o \b\n"+
                        "    o o o \b", g1.toString());
    }

    // @Ignore("Invalid cell position move...")
    @Test (expected = IllegalArgumentException.class)
    public void g1TestMoveFail() {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        g1.move(3,3, 2, 4);
    }

    @Test
    public void g1TestGetGameState() {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        g1.move(2,2, 2, 4);
        g1.getGameState();
        assertEquals(
                "    o o o \b\n"+
                        "    o o o \b\n"+
                        "o o _ _ o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "    o o o \b\n"+
                        "    o o o \b", g1.toString());
    }

    @Test
    public void g1TestIsGameOver() {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        g1.move(2,2, 2, 4);
        assertFalse(g1.isGameOver());
    }

    @Test
    public void g1TestGetScore() {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        g1.move(2,2, 2, 4);
        assertEquals(31, g1.getScore());
    }

    @Test
    public void g2TestMarbleSolitaireModelImpl() {
        MarbleSolitaireModelImpl g2 = new MarbleSolitaireModelImpl();
        assertEquals(
                "    o o o \b\n"+
                        "    o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "o o o _ o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "    o o o \b\n"+
                        "    o o o \b", g2.toString());
    }

    @Test
    public void g3TestMarbleSolitaireModelImpl() {
        MarbleSolitaireModelImpl g3 = new MarbleSolitaireModelImpl(2, 2);
        assertEquals(
                "    o o o \b\n"+
                        "    o o o \b\n"+
                        "o o _ o o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "o o o o o o o \b\n"+
                        "    o o o \b\n"+
                        "    o o o \b", g3.toString());
    }

    // @Ignore("Invalid empty cell position...")
    @Test (expected = IllegalArgumentException.class)
    public void g3TestMarbleSolitaireModelImplFail() {
        MarbleSolitaireModelImpl g3 = new MarbleSolitaireModelImpl(1,1);
    }

    @Test
    public void g4TestMarbleSolitaireModelImpl() {
        MarbleSolitaireModelImpl g4 = new MarbleSolitaireModelImpl(5);
        assertEquals(
                "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "o o o o o o _ o o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b", g4.toString());
    }

    // @Ignore("arm thickness should be a positive odd number")
    @Test (expected = IllegalArgumentException.class)
    public void g4TestMarbleSolitaireModelImplFail() {
        MarbleSolitaireModelImpl g4 = new MarbleSolitaireModelImpl(6);
    }

    @Test
    public void g5TestMarbleSolitaireModelImpl() {
        MarbleSolitaireModelImpl g5 = new MarbleSolitaireModelImpl(5, 5, 5);
        assertEquals(
                "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "o o o o o _ o o o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "o o o o o o o o o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b\n" +
                        "        o o o o o \b", g5.toString());
    }

}