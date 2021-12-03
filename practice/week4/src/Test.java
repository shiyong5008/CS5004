public class Test {
  public static void main(String[] args) {
    Person tom = new Person("Tom", 30, "jdkfdk", "fjdkfjd");

    SantaClaraStore scStore = new SantaClaraStore();
    scStore.addBurger();
    scStore.addFries();
    System.out.println(scStore.checkOut());
    tom.EatFood(scStore.getFood());


    // object variable demo
    // Any object variable is actually a pointer/reference in Java.

    Person p = tom;
    p.setAge(50);
    System.out.println(tom);
  }
}
