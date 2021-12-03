public class SListImpl implements SList {
    // Only need the head as the member varialbe.
    private Node head;

    // creates an empty linked list
    public SListImpl() {
    }

    // creates a linked list with head n
    public SListImpl(Node n) {
        head = n;
    }

    @Override
    public boolean add(String val) {
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
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int pos = 0;
        Node traversePtr = head;

        // we get out of the loop if:
        // 1. when we reach the end of the linked list
        // 2. or when we reach the target 'index'
        while(traversePtr != null && pos != index) {

            // increment the pos
            pos++;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        // when we reach here, we know 'traversePtr' is pointing to the node at the target index
        return traversePtr.val;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int pos = 0;
        Node traversePtr = head;
        Node prevPtr = null;
        while(pos != index) {

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
    public String oddWords() {
        String odd = "";
        Node traversePtr = head;
        while (traversePtr != null) {
            if ((traversePtr.val).length() % 2 == 1) {
                odd = odd + traversePtr.toString();
            }
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return odd;
    }

    @Override
    public String evenWords() {
        String even = "";
        Node traversePtr = head;
        while (traversePtr != null) {
            if ((traversePtr.val).length() % 2 == 0) {
                even = even + traversePtr.toString();
            }
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return even;
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
