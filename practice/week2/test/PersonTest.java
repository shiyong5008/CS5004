import static org.junit.Assert.*;

public class PersonTest {

  //@org.junit.Test
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getSSN() {
    Person tom = new Person("Tom", 31, "43434", "555");
    tom.getSSN("sdjfkdjfdk");
  }

  @org.junit.Test
  public void getAge() {
    Person tom = new Person("Tom", 31, "43434", "555");
    assertEquals(tom.getAge(), 31);
  }
}