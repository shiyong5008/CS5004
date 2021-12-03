import java.util.LinkedList;

public class LinkedListTest {
  public static void main(String[] args) {
    //LinkedList<Integer> list = new LinkedList<>();

    //list.add(1);
    //list.add(2);
    //list.add(4);
    //list.add(5);

    //for (int i = 0; i < list.size(); i++) {
    //  System.out.println(list.get(i));
    //}

    //list.add(2, 3);

    //System.out.println("-----------------");

    //for (int i = 0; i < list.size(); i++) {
    //  System.out.println(list.get(i));
    //}

    //list.remove(3);
    //System.out.println("-----------------");

    //for (int i = 0; i < list.size(); i++) {
    //  System.out.println(list.get(i));
    //}

    Node n6 = new Node(6, null);
    Node n4 = new Node(4, n6);
    Node n3 = new Node(3, n4);
    Node n2 = new Node(2, n3);
    Node n1 = new Node(1, n2);

    MyListImpl list = new MyListImpl(n1);
    System.out.println(list.size());
    System.out.println(list.size());

    System.out.println(list);
  }
}
