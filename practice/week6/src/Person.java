public class Person implements Comparable<Person>{
  private int age;
  private String name;

  public Person(String name, int age) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return this.name + " " + this.age;
  }

  @Override
  public int compareTo(Person o) {
    // compare this Person with Person o
    return this.age - o.getAge();
  }
}
