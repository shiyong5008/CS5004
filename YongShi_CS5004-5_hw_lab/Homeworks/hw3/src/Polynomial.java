/**
 * my polynomial interface.
 * @author Yong Shi
 * @since 2021.6.25
 */
public interface Polynomial {
    Polynomial addTerm(int coe, int pow);
    Polynomial removeTerm(int pow);
    int getDegree();
    int getCoefficient(int pow);
    double evaluate(double num);
    Polynomial add(Polynomial other);

    // helper
    //Polynomial sort();
    //int size(); //and debug use
    Node getHead();
}
