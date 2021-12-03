import java.util.Iterator;

public class MyListImpl<T> implements MyList {
  // Only need the head as the member varialbe.
  // As long as I have the head, I'll be able find
  // all the nodes, following the next pointers.
  private Node<T> head;

  // creates an empty linked list
  public MyListImpl() {
    head = null;
  }

  // creates a linked list with head n
  public MyListImpl(Node n) {
    head = n;
  }

  class MyListIterator implements Iterator<T> {
    Node<T> traversePtr;

    public MyListIterator() {
      traversePtr = head;
    }

    @Override
    public boolean hasNext() {
      return traversePtr != null;
    }

    @Override
    public T next() {
      T val = traversePtr.val;
      traversePtr = traversePtr.next;
      return val;
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new MyListIterator();
  }

  /**
   * Append 'val' to the end of the linked list.
   * @param val This is the value to be appended.
   * @return boolean This indicates whether the add succeeded or not.
   */
  public boolean add(T val) {
    if (head == null) {
      // this is an empty linked list
      // just assign val to the head
      head = new Node(val, null);
      return true;
    }

    Node traversePtr = head;

    while(traversePtr.next != null) { // we keep traversing when the .next is not null
      // jump to the next node
      traversePtr = traversePtr.next;
    }

    // when we reach here, traversePtr is pointing to the last node of the linked list
    traversePtr.next = new Node(val, null);

    return true;
  }

  public T get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    int pos = 0;
    Node<T> traversePtr = head;

    // we get out of the loop if:
    // 1. when we reach the end of the linked list
    // 2. or when we reach the target 'index'
    while(traversePtr != null && pos != index) {
      /*
      if (pos == index) {
        // we've reached the target position.
        // get out of the loop
        break;
      }
       */

      // increment the pos
      pos++;
      // jump to the next node
      traversePtr = traversePtr.next;
    }

    /*
    if (traversePtr == null) {
      // this means when we reach the last node, we still haven't reached the target index.
      // So the target index must be out of boundry
      throw new IndexOutOfBoundsException();
    }
     */

    // when we reach here, we know 'traversePtr' is pointing to the node at the target index
    return traversePtr.val;
  }

  public boolean isEmpty() {
    return head == null;
  }

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
