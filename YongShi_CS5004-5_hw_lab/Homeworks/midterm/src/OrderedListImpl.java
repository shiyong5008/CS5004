public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {
  private Node<E> head;
  private int cap;

  public Node getHead() {
    return head;
  }

  public OrderedListImpl(int capacity) {
    if (capacity<0) {
      throw new IllegalArgumentException("capacity should not less then zero");
    }
    head = null;
    cap = capacity;
  }

  @Override
  public String toString() {
    String res = "";
    Node traversePtr = head;

    for (int i=0; i<cap; i++) {
      if (traversePtr != null) {
        res = res + traversePtr.toString();
        traversePtr = traversePtr.next;
      }else if (traversePtr == null) {
        res = res + "? ";
      }
    }
    return "["+res+"\b]";
  }

  /*
  // this is a sort helper
  public void sort() {
    if (head == null) {
      throw new IllegalArgumentException("this is an empty list");
    }
    Node<E> temp1;
    Node traversePtr = head;
    while (traversePtr != null) {
      // first while loop to track the position, which need swap in if index find higher pow node.
      Node index = traversePtr.next;
      while (index != null) {
        // in side while loop for index to traverse all the next nodes to looking for higher pow node.
        if (traversePtr.val<index.val) {
          // use index to find, if got a higher pow node, swap val with traversePtr's position val.
          temp1 = traversePtr.val;
          traversePtr.val = index.val;
          index.val = temp1;
        }
        // index jump to next position.
        index = index.next;
      }
      // jump to next node position.
      traversePtr = traversePtr.next;
    }
  }
*/

  @Override
  public E getMax() {
    Node traversePtr = head;

    while(traversePtr.next != null) {
      traversePtr = traversePtr.next;
    }
    return (E) traversePtr.val;
  }

  @Override
  public void add(E val) {
    if (head == null) {
      head = new Node(val, null);
    }

    Node traversePtr = head;
    while(traversePtr.next != null) {
      traversePtr = traversePtr.next;
    }
    traversePtr.next = new Node(val, null);
  }

  @Override
  public OrderedList merge(OrderedList other) {
    Node traversePtr = other.getHead();
    while(traversePtr!= null) {
      add((E) traversePtr.val);
      traversePtr = traversePtr.next;
    }
    return this;
  }

  @Override
  public void resize(int newCapacity) {
    if (newCapacity<=this.cap) {
    }
    if (newCapacity>this.cap) {
      this.cap = newCapacity;
    }
  }

}
