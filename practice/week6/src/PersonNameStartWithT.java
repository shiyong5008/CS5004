import java.util.function.Predicate;

public class PersonNameStartWithT implements Predicate<Person> {

  @Override
  public boolean test(Person person) {
    return person.getName().charAt(0) == 'T';
  }
}
