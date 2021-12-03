import java.util.Collections;

public class test {
    public static void main(String[] args) {

        Polynomial p = new PolynomialImpl();
        p = p.addTerm(2, 2);
        p = p.addTerm(1, 1);
        p = p.addTerm(4, 4);
        p = p.addTerm(3, 3);
        p = p.addTerm(5, 5);
        System.out.println(p);
        System.out.println(p.size());
        //System.out.println(p.sort()); //fail

        p = p.removeTerm(3);
        System.out.println(p);

        System.out.println(p.getDegree());
        System.out.println(p.getCoefficient(4));

        System.out.println(p.evaluate(2));

        Collections.sort(p);



    }
}
