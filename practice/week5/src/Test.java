import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    String str = new String("jfkdjfdk");
    String str1 = str;

    // C++
    //string str1 = str;

    // Create an empty linked list.
    MyList list = new MyListImpl();

    System.out.println(list.isEmpty());

    list.add(2);
    list.add(4);
    list.add(6);
    list.add(1);

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

    /*
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
     */

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
    MyListImplR<Integer> list5 = list3.returnMyself();
    list3 = list5.returnMyself();
  }
}
