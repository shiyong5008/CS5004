/**
 * This is going to test the link list implementation. For CS5004/5 lab5.
 *
 * @author  Yong Shi
 * @version 1.0
 * @since   2021-06-16
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is the class for the link list implementation.
 */
public class TListImplTest {

    /**
     * Manually created the link list.
     */
    TNode n6 = new TNode("mark", null);
    TNode n5 = new TNode("tom", n6);
    TNode n4 = new TNode("prof", n5);
    TNode n3 = new TNode("hi", n4);
    TNode n2 = new TNode("world", n3);
    TNode n1 = new TNode("hello", n2);

    TListImpl list = new TListImpl(n1);

    /**
     * Test for the oddWords method.
     */
    @Test
    public void oddWordsTest() {
        assertEquals("hello world tom ", list.oddWords());
        System.out.println(list.oddWords());
    }

    /**
     * Test for the evenWords method.
     */
    @Test
    public void evenWordsTest() {
        assertEquals("hi prof mark ", list.evenWords());
        System.out.println(list.evenWords());
    }

    /**
     * Test for the toString method.
     */
    @Test
    public void testToString() {
        assertEquals("hello world hi prof tom mark ", list.toString());
        System.out.println(list);
    }
}