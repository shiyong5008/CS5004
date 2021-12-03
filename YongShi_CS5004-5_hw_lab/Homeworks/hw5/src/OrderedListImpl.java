public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {
  private Node<E> head;
  private int cap;

  public OrderedListImpl(int capacity) {
    if (capacity<0) {
      throw new IllegalArgumentException("capacity should not less then zero");
    }
    this.head = null;
    this.cap = capacity;
  }

  public Node getHead() {
    return head;
  }

  public int getCap() {
    return cap;
  }

  @Override
  public String toString() {
    String res = "";
    Node traversePtr = head;

    for (int i=0; i<cap; i++) {
      if (traversePtr != null && traversePtr == head) {
        res = res + traversePtr.toString();
        traversePtr = traversePtr.next;
      }else if (traversePtr != null && traversePtr != head) {
        res = res + " " + traversePtr.toString();
        traversePtr = traversePtr.next;
      }else if (traversePtr == null && traversePtr == head) {
        //this is for the scenario when head is null but cap > 1,
        // to print cap qty "?" with correct format, with break out.
        res = res + "?";
        for (int j=1; j<cap; j++) {
          res = res + " ?";
        }
        break;
      }else if (traversePtr == null && traversePtr != head) {
        res = res + " ?";
      }
    }
    return "["+res+"]";
  }
  public void print() {
    int count = 0;
    Node<E> preCheckLength = head;
    while (preCheckLength != null) {
      System.out.println(preCheckLength.val);
      preCheckLength = preCheckLength.next;
    }
  }

  // this is a sort method, just list here as at beginning I
  // wanted to use sort for help add. But that more complicated.
  public void sort() {
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
  }

  @Override
  public E getMax() {
    Node traversePtr = head;
    if (traversePtr == null) {
      return null;
    }
    while(traversePtr.next != null) {
      traversePtr = traversePtr.next;
    }
    return (E) traversePtr.val;
  }

  public boolean compare(E o1, E o2) {
    return o1.compareTo(o2)>0;
  }

  /* // recursive try
  @Override
  public void add(E val) {
    int size = this.size();
    System.out.println(size);
    if (this.getCap()<this.size()) {
      if (this.size()==0) {
        head = new Node(val, null);
      }else {
        Node<E> traversePtr = new Node(val, null);;
        Node<E> dummy = new Node(val, null);
        dummy.next = this.head;
        Node<E> pointer = head;
        while (pointer!=null && pointer.next!=null && !compare((E) pointer.next.val, val)) {
          pointer=pointer.next;
        }
        dummy.next = pointer.next;
        pointer.next = new Node(val, null);
        this.head = traversePtr.next;
      }
    }else if (head!=null && !compare((E) head.val, val)) {
      this.head = this.head.next;
      this.add(val);
    }
  }

  private int size() {
    int count = 0;
    Node<E> preCheckLength = head;
    while (preCheckLength != null) {
      count++;
      preCheckLength = preCheckLength.next;
    }
    return count;
  }
*/

//  /*
  @Override
  public void add(E val) {
    if (head == null) {
      head = new Node(val, null);
    } else if (head != null) {

      int k = 1;
      Node<E> preCheckLength = head;
      while (preCheckLength.next != null) {
        k++;
        preCheckLength = preCheckLength.next;
      }

      E preHeadVal = head.val;
      boolean doneFlag = false;
      Node<E> traversePtr = head;
      Node<E> pre = new Node (0, head);

      while (traversePtr != null) {
        int i = 1;
        Node<E> checkLength = head;
        while (checkLength.next != null) {
          i++;
          checkLength = checkLength.next;
        }
        if (!compare(val, traversePtr.val) && i<cap && traversePtr==head) {
//        if ((Integer)val <= (Integer)traversePtr.val && i<cap && traversePtr==head) {
          Node<E> temp = head;
          head = new Node(val, temp);
          doneFlag = true;
          break;
        }else if (!compare(val, traversePtr.val) && i<cap && traversePtr!=head) {
//        }else if ((Integer)val <= (Integer)traversePtr.val && i<cap && traversePtr!=head) {
          pre.next = new Node(val, traversePtr);
          doneFlag = true;
          break;
        }else if (!compare(val, traversePtr.val) && i==cap && traversePtr==head) {
//        }else if ((Integer)val <= (Integer)traversePtr.val && i==cap && traversePtr==head) {
          doneFlag = true;
          break;
        }else if (!compare(val, traversePtr.val) && i==cap && traversePtr!=head) {
//        }else if ((Integer)val <= (Integer)traversePtr.val && i==cap && traversePtr!=head) {
          pre.next = new Node(val, traversePtr);
          head = head.next;
          doneFlag = true;
          break;
        }
        traversePtr = traversePtr.next;
        pre = pre.next;
      }

      int j = 1;
      Node<E> postCheckLength = head;
      while (postCheckLength.next != null) {
        j++;
        postCheckLength = postCheckLength.next;
      }
      if (doneFlag == false && j==k && preHeadVal==head.val && j<cap) {
        pre.next = new Node(val, null);
      }else if (doneFlag == false && j==k && preHeadVal==head.val && j==cap) {
        pre.next = new Node(val, null);
        head = head.next;
      }
    }
  }
// */

  @Override
  public OrderedList merge(OrderedList other) {
    int l1= cap;
    int l2 = other.getCap();

    int capNew = l1+l2;
    OrderedList<E> list = new OrderedListImpl<E>(capNew);

    Node traversePtr = head;
    while(traversePtr!= null) {

      list.add((E) traversePtr.val);
      traversePtr = traversePtr.next;
    }
    Node traversePtr2 = other.getHead();
    while(traversePtr2!= null) {
      list.add((E) traversePtr2.val);
      traversePtr2 = traversePtr2.next;
    }
    return list;
  }

  @Override
  public void resize(int newCapacity) {
    OrderedList<E> list = new OrderedListImpl<E>(this.getCap());

    Node traversePtr = head;
    while (traversePtr != null) {
      list.add((E)traversePtr.val);
      traversePtr = traversePtr.next;
    }

    Node traversePtr2 = list.getHead();

    this.head.next = null;
    this.head = null;
    this.cap = newCapacity;

    while (traversePtr2 != null) {
      this.add((E)traversePtr2.val);
      traversePtr2 = traversePtr2.next;
    }
  }

}
