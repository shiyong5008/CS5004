// lab3_0. Create a new subclass of Person, called Scientist
public class Scientist extends Person {
    private String specialty;

    public Scientist(String name, int age, String SSN, String password, String specialty) {
        // call the Person' construtor to create the internal Person object
        super(name, age, SSN, password);
        // initialize Scientist's own member variable
        this.specialty = specialty;
        specialty = "ComputerScience";
    }

    public String getspecialty() {
        if (this.specialty == "") {
            throw new IllegalArgumentException("specialty is empty!");
        }
        return this.specialty;
    }

    // Mutator method to set the value
    public void setspecialty(String specialty) {
        this.specialty = specialty;
    }

    // We don't like toString() inherited from the parent Object class,
    // so *override* it with our own version
    @Override
    public String toString() {
        // string concatenation
        return "This is Scientist Name: " + getName() + " Age: " + getAge() + " specialty: " + getspecialty();
    }

    // my test codes
    public static void main(String[] args) {
        Scientist s1 = new Scientist("Tom", 30, "fjdkfj", "1222", "Java");
        System.out.println(s1.getName());

        Scientist s2 = new Scientist("Jack", 35, "fjkd", "222", "Python");
        System.out.println(s2.getName());

        // test toString()
        System.out.println(s1);
        System.out.println(s2.toString());

        //test for IllegalArgumentException: specialty is empty
        Scientist s3 = new Scientist("empty name", 35, "fjkd", "222", "");
        System.out.println(s3.getName());
        System.out.println(s3);
    }
}