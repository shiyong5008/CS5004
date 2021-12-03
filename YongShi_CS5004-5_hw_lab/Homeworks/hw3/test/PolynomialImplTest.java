import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialImplTest {

    @Test
    public void addTerm() {
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);
        assertEquals("\"-5x^5 +4x^4 -2x^3 -2x^2 -3x^1\"", p.toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addTermFail() {
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, -2);
    }

    @Test
    public void removeTerm() {
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);
        p = p.removeTerm(3);
        p = p.removeTerm(5);
        assertEquals("\"4x^4 -2x^2 -3x^1\"", p.toString());
    }

    @Test
    public void getDegree() {
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);
        assertEquals(5, p.getDegree());
    }

    @Test
    public void getCoefficient() {
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);
        assertEquals(4, p.getCoefficient(4));
    }

    @Test
    public void evaluate() {
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);
        assertEquals(-126.0, p.evaluate(2.0), 0.001);
    }

    @Test
    public void add() {
        /**
         * create polynomial p.
         */
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);

        /**
         * create polynomial p2.
         */
        Polynomial p2 = new PolynomialImpl();
        p2 = p2.addTerm(2, 2);
        p2 = p2.addTerm(1, 1);
        p2 = p2.addTerm(-6, 4);
        p2 = p2.addTerm(3, 3);
        p2 = p2.addTerm(6, 5);

        assertEquals("\"1x^5 -2x^4 +1x^3 -2x^1\"", p.add(p2).toString());
    }



}