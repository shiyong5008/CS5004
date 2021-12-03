public class Person {
  // fields or member variables
  private String name;
  private int age;
  private String SSN;
  private String passwd;

  // protected, default

  //------------------------------------------------

  // Helper
  // Returns true when the entered passwd matches the person's secret passwd
  private boolean AuthenticateUser(String passwd) {
    if (this.passwd.equals(passwd)) {
      return true;
    } else {
      return false;
    }
  }

  // -----------------------------------------------

  // constructor
  public Person(String name, int age, String SSN, String passwd) {
    this.name = name;
    this.age = age;
    this.SSN = SSN;
    this.passwd = passwd;
  }

  // Accessor method to get the SSN of this Person
  // Passwd is required
  public String getSSN(String passwd) {
    // do some authentication here to verify the user
    if (this.AuthenticateUser(passwd) == false) {
      // report authentication failure to the caller
      throw new IllegalArgumentException("Authentication failed. Wrong password!");
      //return "";
    }
    System.out.println("Authentication passed!");
    // do some error checking...
    return this.SSN;
  }

  // Mutator method to set the value of SSN
  public void setSSN(String SSN) {
    this.SSN = SSN;
  }

  // Accessor method to get the age of this Person
  public int getAge() {
    return this.age;
  }

  // Mutator method to set the value of age
  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  // I don't want to provide setName because I don't allow changing name

  // ================================================

  public static void utilityMethod() {
    System.out.println("Hello world!");
  }
}
