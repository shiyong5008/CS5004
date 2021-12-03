import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class PetRockTest {

    private PetRock rocky;

    // timeout rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);
    // 10s max

    @Before
    public void myTestSetUp() throws Exception {
        rocky = new PetRock("Rocky");
    }

    @Test
    public void getName() {
        // PetRock rocky = new PetRock("Rocky");
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnhappyToStart() throws Exception {
        // PetRock rocky = new PetRock("Rocky");
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() throws Exception {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Ignore("Exception throwing not yet defined")
    @Test (expected = IllegalStateException.class)
    public void nameFail() throws Exception {
        rocky.getHappyMessage();
    }

    @Test
    public void name() throws Exception {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test
    public void testFavNumber() throws Exception {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyNameFail() throws Exception {
        new PetRock("");
    }

    @Test (timeout = 100) // in ms
    public void waitForHappyTimeout() throws Exception {
        rocky.waitTillHappy();
    }

    //3 Add to the Pet Rock an example of a test not covered in the first 2 parts of the lab.
    @Test
    public void isSame() {
        assertSame("90kg", rocky.getWeight());
    }

    //4 Add a toString method to the Pet Rock and JUnit testing for it.
    @Test
    public void testToString() {
        assertSame("Jerry", rocky.toString());
        System.out.println(rocky.toString());
        System.out.println(rocky.getWeight());
    }
}