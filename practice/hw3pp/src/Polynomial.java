
public interface Polynomial {
    Polynomial addTerm(int coe, int pow);
    Polynomial removeTerm(int pow);
    int getDegree();
    int getCoefficient(int pow);
    double evaluate(double num);

    /*
    Polynomial add(Polynomial other);
    */

    //Polynomial sort();
    int size();

}
