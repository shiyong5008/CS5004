import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    // use 'new' to create an object out of class Person
    // instantiate class Person
    String correctPasswd = "correctpassowrd";
    Person tom = new Person("Tom", 30, "2345", correctPasswd);
    Person.utilityMethod();

    // tom.name = "Tom";
    // tom.age = 30;
    // p.SSN = "2345";
    Scanner myObj = new Scanner(System.in);
    int attempts = 0;
    while (true) {
      //String wrongPasswd = "ssssss";
      System.out.println("Enter password: ");
      String userInputPasswd = myObj.nextLine();
      try {
        String ssn = tom.getSSN(userInputPasswd);
        // When we reach the 'break' here, it means you didn't go to the catch block due to
        // a wrong password. So we don't need to try again, break out of the loop.
        break;
      } catch (IllegalArgumentException e) {
        // handle the exception thrown by getSSN
        System.out.println(e);
        attempts++;
        if (attempts == 3) {
          // attempts exhausted. Deny access!
          System.out.println("Failed three times! Access denied!");
          break;
        }
      }
    }

    int oldAge = tom.getAge();
    System.out.println(oldAge);
    tom.setAge(31);
    int newAge = tom.getAge();
    System.out.println(newAge);

    // tom.AuthenticaUser();

    System.out.println(tom.getName());
  }
}
