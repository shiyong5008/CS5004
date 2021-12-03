import org.junit.Test;

import static org.junit.Assert.*;

public class CSuiteManagerTest {
    CSuiteManager CS1 = new CSuiteManager("Tom", 30, "fjdkfj", "1222", 2,
            2, 1.00, "CTO");

    // test to String and getName inherited without change from Person still works correctly
    @Test
    public void toStringTest() {
        assertSame("Tom", CS1.getName());
        System.out.println(CS1.toString());
    }

    @Test
    public void getcostTest() {
        assertEquals(2.00, CS1.getcost(), 0.00);
    }

    @Test
    public void setoptionTest() {
        assertEquals(7, CS1.setoption(5), 0.00);
    }

    @Test
    public void capitalGainsTest() {
        CS1.setoption(5);
        assertEquals(35, CS1.capitalGains(6), 0.00);
    }
}