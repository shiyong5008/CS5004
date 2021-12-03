import java.util.Collections;

public class PolynomialImpl implements Polynomial {
    // Only need the head as the member varialbe.
    private Node head;
    // creates an empty linked list
    public PolynomialImpl() {
    }
    // creates a linked list with head n
    public PolynomialImpl(Node n) {
        head = n;
    }
/*
    @Override
    public Polynomial addTerm(int coe, int pow) {
        if (pow < 0) {
            throw new IndexOutOfBoundsException();
        }
        int term[] = new int[2];
        term[0] = coe;
        term[1] = pow;
        if (head == null) {
            // this is an empty linked list
            // just assign val to the head
            head = new Node(term, null);
            return this;
        }
        Node traversePtr = head;
        while(traversePtr.next != null) { // we keep traversing when the .next is not null
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        // when we reach here, traversePtr is pointing to the last node of the linked list
        traversePtr.next = new Node(term, null);
        return this;
    }
*/
    @Override
    public Polynomial addTerm(int coe, int pow) {
        if (pow < 0) {
            throw new IndexOutOfBoundsException();
        }
        int term[] = new int[2];
        term[0] = coe;
        term[1] = pow;
        if (head == null) {
            // this is an empty linked list
            // just assign val to the head
            head = new Node(term, null);
            return this;
        }
        Node traversePtr = head;
        while(traversePtr.next != null) { // we keep traversing when the .next is not null
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        // when we reach here, traversePtr is pointing to the last node of the linked list
        traversePtr.next = new Node(term, null);
        return this;
    }

    @Override
    public Polynomial removeTerm(int pow) {
        if (pow < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node traversePtr = head;
        Node prevPtr = null;
        while(pow != traversePtr.getPow()) {
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
            return this;
        }
        prevPtr.next = traversePtr.next;
        return this;
    }
/*
    public Polynomial sort() {
        int temp1[] = new int[2];
        int temp2[] = new int[2];
        Node traversePtr = head;
        for (int i=0; i<size(); i++) {
            for (int j=0; j<size(); j++) {
                if (traversePtr.getPow() < traversePtr.next.getPow()) {
                    temp1[0] = traversePtr.getCoe();
                    temp1[1] = traversePtr.getPow();
                    temp2[0] = traversePtr.next.getCoe();
                    temp2[1] = traversePtr.next.getPow();

                    traversePtr.next.setCoe(temp1[0]);
                    traversePtr.next.setPow(temp1[1]);
                    traversePtr.setCoe(temp2[0]);
                    traversePtr.setPow(temp2[1]);

                    traversePtr = traversePtr.next;
                }
                traversePtr = head;
            }
        }
        return this;
    }
*/
    @Override
    public int getDegree() {
        Node high = head;
        Node traversePtr = head;
        while (traversePtr.next != null) {
            if (high.getPow() < traversePtr.next.getPow()) {
                high = traversePtr.next;
            }
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return high.getPow();
    }

    @Override
    public int getCoefficient(int pow) {
        Node high = head;
        Node traversePtr = head;
        while (traversePtr!= null && pow != traversePtr.getPow()) {
            // increment the pos
            // before we jump to the next node, set the 'prevPtr' to point to the current node
            high = traversePtr.next;
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return high.getCoe();
    }

    @ Override
    public double evaluate(double num) {
        double res = 0;
        Node traversePtr = head;
        while (traversePtr != null) {
            // increment the pos
            // before we jump to the next node, set the 'prevPtr' to point to the current node
            res = res + traversePtr.getCoe()*Math.pow(num, traversePtr.getPow());
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return res;
    }

    @ Override
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
