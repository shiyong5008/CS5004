import org.junit.Test;

import static org.junit.Assert.*;

public class Vector3DTest {

    Vector3D original = new Vector3D(2.3, 3.5, 4.4);

    @Test
    public void test1() {
        assertEquals(original.toString(), "(2.30, 3.50, 4.40)");
    }

    @Test
    public void test2() {
        assertEquals(original.getMagnitude(), 6.074537019, .000000001);
    }

    @Test
    public void test3() {
        double normOrig = original.normalize();
        assertEquals(normOrig, .378629679, .000000001);
    }

    @Test
    public void test4() {
        Vector3D other = new Vector3D(6.67, 3.45, 9.23);
        double angle = original.angleBetween(other);
        assertEquals(angle, 0.34472741090991177, .000000001);
    }
}