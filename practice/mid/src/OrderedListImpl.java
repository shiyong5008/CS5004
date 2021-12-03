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
      }else if (traversePtr == null && i<cap-1) {
        res = res + "? ";
      }else if (traversePtr == null && i==cap-1) {
        res = res + "?";
      }
    }
    return "["+res+"]";
  }


  // this is a sort helper
  public OrderedList sort() {
    if (head == null) {
      throw new IllegalArgumentException("this is an empty list");
    }
    Node traversePtr = head;
    while (traversePtr != null) {
      // first while loop to track the position, which need swap in if index find higher val node.
      Node index = traversePtr.next;
      while (index != null) {
        // in side while loop for index to traverse all the next nodes to looking for higher val node.
        if ((Integer)traversePtr.val>(Integer)index.val) {
          // use index to find, if got a higher val node, swap val with traversePtr's position val.
          Comparable<Integer>temp1;
          temp1 = (Integer)traversePtr.val;
          traversePtr.val = index.val;
          index.val = temp1;
        }
        // index jump to next position.
        index = index.next;
      }
      // jump to next node position.
      traversePtr = traversePtr.next;
    }
    return this;
  }

  @Override
  public E getMax() {
    Node traversePtr = head;

    while(traversePtr.next != null) {
      traversePtr = traversePtr.next;
    }
    return (E) traversePtr.val;
  }

  @Override
  public OrderedList add(E val) {
    if (head == null) {
      head = new Node(val, null);
      return this;
    }

    Node traversePtr = head;
    Node pre = null;

    while(traversePtr.next != null) {
      pre = traversePtr;
      traversePtr = traversePtr.next;
    }
    traversePtr.next = new Node(val, null);
    return this.sort();
  }

  @Override
  public OrderedList merge(OrderedList other) {

    Node tr = head;
    int l1=1;
    while(tr!= null) {
      tr = tr.next;
      l1++;
    }

    Node traversePtr = other.getHead();
    int l2=1;
    while(traversePtr!= null) {
      add((E) traversePtr.val);
      traversePtr = traversePtr.next;
      l2++;
    }
    cap = l2+l1;
    return this.sort();
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
