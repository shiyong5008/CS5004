/**
 * test class for test on my polynomial operations.
 * @author Yong Shi
 * @since 2021.6.25
 */
public class test {
    public static void main(String[] args) {

        /**
         * create polynomial p and print.
         */
        Polynomial p = new PolynomialImpl();
        p = p.addTerm(-2, 2);
        p = p.addTerm(-3, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(-2, 3);
        p = p.addTerm(-5, 5);
        System.out.println(p);

        /**
         * create polynomial p2 and print.
         */
        Polynomial p2 = new PolynomialImpl();
        p2 = p2.addTerm(2, 2);
        p2 = p2.addTerm(1, 1);
        p2 = p2.addTerm(-6, 4);
        p2 = p2.addTerm(3, 3);
        p2 = p2.addTerm(6, 5);
        System.out.println(p2);

        /**
         * test add and remove.
         */
        System.out.println(p.add(p2));
        p = p.removeTerm(3);
        p = p.removeTerm(5);
        System.out.println(p);

        /**
         * test getDefree and coe and evaluate.
         */
        System.out.println(p.getDegree());
        System.out.println(p.getCoefficient(4));
        System.out.println(p.evaluate(2));

        // debug used
        // System.out.println(p.sort());
        // System.out.println(p.size());
    }
}
