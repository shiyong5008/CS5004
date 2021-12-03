public class Test {

  // Utility method: prints the names of an array of people
  public static void printNames(PrimitivePerson[] people) {
    for (int i = 0; i < people.length; i++) {
      //if (people[i] instanceof Person) {
      //  Person p = (Person) people[i];
      //  System.out.println(p.toString());
      //} else if (people[i] instanceof Engineer) {
      //  Engineer e = (Engineer) people[i];
      //  System.out.println(e.toString());
      //} else if (people[i] instanceof Manager) {
      //  Manager m = (Manager) people[i];
      //  System.out.println(m.toString());
      //}
      //System.out.println(people[i].getName());
      System.out.println(people[i].toString());
    }
  }

  public static void main(String[] args) {
    Engineer e = new Engineer("Tom", 30, "fjdkfj", "1222", "Java");
    System.out.println(e.getName());

    Manager m = new Manager("Jack", 35, "fjkd", "222", 5);
    System.out.println(m.getName());

    // test toString()
    System.out.println(e);
    System.out.println(m.toString());

    Person p1 = new Person("Tom1", 34, "111", "111");
    Person p2 = new Person("Tom2", 34, "111", "111");
    System.out.println(p1.equals(p2));

    // Use parent class to represent child object!!!
    //Person p3 = new Engineer("Jim", 30, "fjdkfdkj", "232", "C++");
    Engineer e2 = new Engineer("Jim", 30, "fjdkfdkj", "232", "C++");
    Person p3 = e2;


    // We know p3 is actually an Engineer
    // Type casting -- cast a parent type to a child type
    Engineer e3 = (Engineer)p3;

    // WRONG!!
    //Manager m4 = (Manager)e3;

    //////////// another example of type casting /////////////
    int a = 3;
    double b = a;
    int c = (int)b;
    double val;
    // func(int arg);

    System.out.println("==========================================");
    Person[] people = new Person[] {e, m, p1, p2, p3};
    Test.printNames(people);
    System.out.println("==========================================");

    // A person doesn't have to be an engineer
    // Engineer e2 = new Person("XXX", 323, "fjdkfjd");


    String ssn1 = new String("123");
    Person p11 = new Person("Tom", 30, ssn1, "111");
    String ssn2 = new String("123");
    Person p12 = new Person("Tom", 30, ssn2, "111");
    System.out.println(p11.equals(p12));
    System.out.println(p11.equals("Tom"));


    // Shape example test
    // Shape s = new Shape("red");














  }
}
