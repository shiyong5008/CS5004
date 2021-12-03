import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
  public static void main(String[] args) {
    String str = new String("jfkdjfdk");
    String str1 = str;

    // C++
    //string str1 = str;

    /*
    // Create an empty linked list.
    MyList list = new MyListImpl();

    System.out.println(list.isEmpty());

    list.add(2);
    list.add(4);
    list.add(6);
    list.add(1);

    list.remove2(6);
    System.out.println(list);

    System.out.println(list.isEmpty());

    System.out.println(list);

    System.out.println(list.get(0));
    System.out.println(list.get(2));
    System.out.println(list.get(list.size()-1));
    try {
      System.out.println(list.get(list.size()));
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }

    System.out.println(list.remove(2));
    System.out.println(list);

    System.out.println(list.remove(0));
    System.out.println(list);
    System.out.println(list.remove(list.size()-1));
    System.out.println(list);
    System.out.println(list.remove(list.size()-1));
    System.out.println(list);

    list.remove2(4);
    System.out.println(list);
    list.remove2(2);
    System.out.println(list);

    MyList list2 = list.subList(0, list.size()-1);
    System.out.println(list2);

    System.out.println("===========================");
    MyListImplR<Integer> list3 = new MyListImplR<>(4);
    list3.add(2);
    list3.add(3);
    list3.add(1);

    System.out.println(list3);

    System.out.println(list3.get(0));
    System.out.println(list3.get(1));

    System.out.println(list3.size());
    System.out.println(list3.get(list3.size()-1));

    System.out.println("=========================");
    System.out.println(list3.remove(2));
    System.out.println(list3.remove(0));
    System.out.println("=========================");

    MyListImplR<Person> list4 = new MyListImplR<Person>(new Person());
    list4.add(new Person());

    ArrayList<Integer> array = new ArrayList<>();

    // The following is equal to
    // MyListImplR<Integer> list5 = list3;
    MyListImplR list5 = new MyListImplR(3);
    list5.add(2);
    list5.add(4);
    list5.add(1);
    list5.add(5);
    //System.out.println(list5);
    //MyListImplR newlist = list5.removeHead(true);
    System.out.println(list5);
    System.out.println(list5.subList());
    newlist = list5.removeHead(false);
    System.out.println(newlist); // newlist should still be list5
    System.out.println("=========================");
    System.out.println(list5.remove(2));
    System.out.println(list5.remove(0));
    System.out.println("=========================");

    MyListInterface empty = new EmptyLinkedList();
    MyListInterface list1 = new NonEmptyLinkedList(2, empty);
    MyListInterface list2 = new NonEmptyLinkedList(3, list1);
    MyListInterface list3 = new NonEmptyLinkedList(1, list2);
    MyListInterface list4 = new NonEmptyLinkedList(5, list3);
    System.out.println(list4.size());
    System.out.println(list4);

    MyListInterface<Person> people = new EmptyLinkedList<>();
    people = people.add(new Person("Tom", 30));
    people = people.add(new Person("Tim", 15));
    people = people.add(new Person("Jack", 25));
    people = people.add(new Person("To", 15));
    System.out.println(people);

    //MyListInterface<Person> drink = people.subList(new PersonLegalToDrink());
    //System.out.println(drink);

    MyListInterface<Person> T = people.subList(new PersonNameStartWithT());
    System.out.println(T);
    ArrayList<Person> people = new ArrayList<>();
    people.add(new Person("Tom", 30));
    people.add(new Person("Tim", 15));
    people.add(new Person("Jack", 25));
    System.out.println(people);
    Collections.sort(people);
    System.out.println(people);
    Collections.sort(people, new CompareNameComparator());
    System.out.println(people);

    for (int i = 0; i < people.size(); i++) {
      System.out.println(people.get(i));
    }

    Iterator<Person> it = people.iterator();
    while(it.hasNext()) {
      Person p = it.next();
      System.out.println(p);
    }

    Set<Person> peopleInBST = new TreeSet();
    peopleInBST.add(new Person("Tom", 30));
    peopleInBST.add(new Person("Tim", 15));
    peopleInBST.add(new Person("Jack", 25));
    Iterator<Person> it2 = peopleInBST.iterator();
    while(it2.hasNext()) {
      Person p = it2.next();
      System.out.println(p);
    }
     */

    System.out.println("===========================");
    MyListImpl<Person> people = new MyListImpl<>();
    people.add(new Person("Tom", 30));
    people.add(new Person("Tim", 15));
    people.add(new Person("Jack", 25));
    people.add(new Person("To", 15));
    Iterator<Person> it3 = people.iterator();
    while(it3.hasNext()) {
      Person p = it3.next();
      System.out.println(p);
    }
  }
}
