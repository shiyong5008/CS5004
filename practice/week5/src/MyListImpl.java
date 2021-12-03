public class MyListImpl implements MyList {
  // Only need the head as the member varialbe.
  // As long as I have the head, I'll be able find
  // all the nodes, following the next pointers.
  private Node head;

  // creates an empty linked list
  public MyListImpl() {
    head = null;
  }

  // creates a linked list with head n
  public MyListImpl(Node n) {
    head = n;
  }

  /**
   * Append 'val' to the end of the linked list.
   * @param val This is the value to be appended.
   * @return boolean This indicates whether the add succeeded or not.
   */
  @Override
  public boolean add(int val) {
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

  @Override
  public int get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    int pos = 0;
    Node traversePtr = head;

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
  /**
   * Remove 'val' from the linked list. It is guaranteed that there's
   * only one occurance of 'val' in the linked list.
   * @param val This is the value to be removed.
   */
  @Override
  public void remove2(int val) {
    Node dummy = new Node(-1, null);
    Node traversePtrForNew = dummy;

    Node traversePtr = head;

    while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
      if (traversePtr.val == val) {
        // this is the node that we want to remove, so skip it
        // do nothing
      } else {
        // this is a node that we want to keep, so append it to the new linked list
        traversePtrForNew.next = traversePtr;
        traversePtrForNew = traversePtrForNew.next;
      }

      // always jump to the next node
      traversePtr = traversePtr.next;
    }

    head = dummy.next;
  }

  @Override
  public int remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    int pos = 0;
    Node traversePtr = head;
    Node prevPtr = null;
    while(pos != index) {
      /*
      if (pos == index) {
        // we've reached the target position.
        // get out of the loop
        break;
      }
       */

      // increment the pos
      pos++;
      // before we jump to the next node, set the 'prevPtr' to point to the current node
      prevPtr = traversePtr;
      // jump to the next node
      traversePtr = traversePtr.next;
    }

    // when we reach here, we know 'traversePtr' is pointing to the node at the target index
    // now remove the node that 'traversePtr' is pointing to, by setting .next of 'prevPtr' to
    // the next of 'traversePtr'.
    if (prevPtr == null) {
      // we're removing the first node,
      // set the head to the next of 'traversePtr'
      head = traversePtr.next;
      return traversePtr.val;
    }

    prevPtr.next = traversePtr.next;
    return traversePtr.val;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
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

  /**
   * Returns a new linked list that contains copies of the nodes from index [fromIndex, toIndex]
   * from this linked list.
   * @param fromIndex This is the starting index.
   * @param toIndex This is the end index.
   * @return Returns the new linked list.
   */
  @Override
  public MyList subList(int fromIndex, int toIndex) {
    Node dummy = new Node(-1, null);
    Node traversePtrForNew = dummy;

    int pos = 0;
    Node traversePtr = head;

    while(traversePtr != null) {
      if (pos < fromIndex) {
        // haven't reached the range yet, do nothing
      } else if (pos >= fromIndex && pos <= toIndex) {
        // This is a node that we want, so add it to the
        // new linked list
        traversePtrForNew.next = new Node(traversePtr.val, null);
        traversePtrForNew = traversePtrForNew.next;
      } else if (pos > toIndex) {
        // we're done
        break;
      }

      // increment the pos
      pos++;
      // jump to the next node
      traversePtr = traversePtr.next;
    }

    return new MyListImpl(dummy.next);
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
