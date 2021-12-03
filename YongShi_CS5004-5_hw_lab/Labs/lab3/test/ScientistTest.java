import org.junit.Test;

import static org.junit.Assert.*;

public class ScientistTest {

    @Test (expected = IllegalArgumentException.class)
    public void getspecialtyTest() throws Exception {
        Scientist s1 = new Scientist("Tom", 30, "fjdkfj", "1222", "");
        assertEquals("", s1.getspecialty());
        System.out.println(s1.getspecialty());
    }

    // test toString and also test getName method inherited from Person without change still works correctly
    @Test
    public void toStringTest() {
        Scientist s2 = new Scientist("Jack", 35, "fjkd", "222", "Python");
        assertSame("Jack", s2.getName());
        System.out.println(s2.toString());
    }

    // test fails
    @Test
    public void getspecialtyTestFails() throws Exception {
        Scientist s1 = new Scientist("Tom", 30, "fjdkfj", "1222", "");
        assertEquals("", s1.getspecialty());
        System.out.println(s1.getspecialty());
    }
}