import java.util.function.Predicate;

public class PersonLegalToDrink implements Predicate<Person> {

  @Override
  public boolean test(Person person) {
    return person.getAge() >= 21;
  }
}
