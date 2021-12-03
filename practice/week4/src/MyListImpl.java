public class MyListImpl implements MyList {
  // Only need the head as the member varialbe.
  // As long as I have the head, I'll be able find
  // all the nodes, following the next pointers.
  private Node head;

  // creates an empty linked list
  public MyListImpl() {
  }

  // creates a linked list with head n
  public MyListImpl(Node n) {
    head = n;
  }

  @Override
  public boolean add(int val) {
    return false;
  }

  @Override
  public int get(int index) {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int remove(int index) {
    return 0;
  }

  @Override
  public int size() {
    int counter = 0;
    Node traversePtr = head;

    while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
      // increment the counter
      counter++;
      // jump to the next node
      traversePtr = traversePtr.next;
    }

    return counter;
  }

  @Override
  public MyList subList(int fromIndex, int toIndex) {
    return null;
  }

  @Override
  public String toString() {
    String res = "";
    Node traversePtr = head;

    while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
      res = res + traversePtr.toString();
      // jump to the next node
      traversePtr = traversePtr.next;
    }

    return res;
  }
}
