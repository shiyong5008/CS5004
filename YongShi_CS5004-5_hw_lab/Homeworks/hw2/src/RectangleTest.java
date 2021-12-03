import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Rectangle class.
 */
public class RectangleTest {
    private Rectangle r4;
    private Rectangle r5;
    private Rectangle r6;
    private Rectangle r7;
    private Rectangle r8;
    private Rectangle r9;

    /**
     * setup for the Rectangle objectives.
     */
    @Before
    public void setUp() {
        r4 = new Rectangle(2,2,4,7);
        r5 = new Rectangle(3,5,5,6);
        r6 = new Rectangle(4, 6, 6, 4);
        r7 = new Rectangle(3, 4, 49,4);
        r8 = new Rectangle(-86,-44, 2,3);
        r9 = new Rectangle(0,0,20,15);
    }

    /**
     * test for the weight and height when <=0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTransmissionBoxIllegalArgumentException() {
        Rectangle r1 = new Rectangle(0,0,0,0);
        Rectangle r2 = new Rectangle(-5,-2,-5,-4);
        Rectangle r3 = new Rectangle(9, 3, -3, -8);
    }

    /**
     * test for the overlap.
     */
    @Test
    public void testOverlap() {
        assertEquals(true, r4.overlap(r5));
        assertEquals(true, r4.overlap(r7));
        assertFalse("false", r8.overlap(r4));
        assertEquals(true, r7.overlap(r6));
        assertEquals(true, r5.overlap(r6));
        assertFalse("false", r8.overlap(r5));
        assertEquals(true, r6.overlap(r4));
        assertEquals(true, r9.overlap(r4));
    }

    /**
     * test for the intersect.
     */
    @Test
    public void testIntersect() {
        assertEquals(new Rectangle(3,5,3,4).toString(), r4.intersect(r5).toString());
    }

    /**
     * test for the union.
     */
    @Test
    public void testUnion() {
        assertEquals(new Rectangle(2,2,6,9).toString(), r4.union(r5).toString());
        assertEquals(new Rectangle(2,2,6,9).toString(), r5.union(r4).toString());
        assertEquals(new Rectangle(-86,-44,106,59).toString(), r8.union(r9).toString());
        assertEquals(new Rectangle(3,4,49, 6).toString(), r6.union(r7).toString());
    }

    /**
     * test for the toString.
     */
    @Test
    public void testToString() {
        assertEquals("x:2, y:2, w:4, h:7", r4.toString());
    }
}
