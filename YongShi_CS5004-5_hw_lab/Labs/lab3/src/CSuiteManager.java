// lab3_1. Add a subclass of Manager, called a CSuiteManager.
public class CSuiteManager extends Manager {
    private int stockOptions = 0;
    private double strikePrice = 1.00;
    private String fancyTitle = "Chief Technical Officer";

    public CSuiteManager(String name, int age, String SSN, String passwd, int numSubordinates,
                         int stockOptions, double strikePrice, String fancyTitle) {
        // use "super" to invoke the constructor of the Manager class,
        // to create an internal Manager object
        super(name, age, SSN, passwd, numSubordinates);
        this.stockOptions = stockOptions;
        this.strikePrice = strikePrice;
        this.fancyTitle = fancyTitle;
    }

    // We don't like toString() inherited from the parent Object class,
    // so *override* it with our own version
    @Override
    public String toString() {
        // string concatenation
        return "This is Scientist Name: " + getName() + " Age: " + getAge() + " fancyTitle: " + fancyTitle;
    }

    public double getcost() {
        return strikePrice * stockOptions;
    }
    public int setoption(int increase) {
        if (increase <= 0) {
            throw new IllegalArgumentException("increase wrong!");
        }
        return stockOptions = this.stockOptions+increase;
    }

    public double capitalGains(double marketPrice) {
        return (marketPrice-this.strikePrice)*this.stockOptions;
    }

    // my test codes
    public static void main(String[] args) {
        CSuiteManager CS1 = new CSuiteManager("Tom", 30, "fjdkfj", "1222", 2,
                2, 1.00, "CTO");
        System.out.println(CS1.getName());
        CS1.setoption(5);
        System.out.println(CS1.stockOptions);
        System.out.println(CS1.capitalGains(6.00));
        // test toString() System.out.println(CS1);
        System.out.println(CS1.toString());
        // test IllegalArgumentException: increase wrong!
        CS1.setoption(0);
    }
}
