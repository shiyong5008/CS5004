import java.util.Comparator;

public class CompareNameComparator implements Comparator<Person> {

  @Override
  public int compare(Person o1, Person o2) {
    int name1 = o1.getName();
    int name2 = o2.getName();
    return name1-name2;
  }
}
