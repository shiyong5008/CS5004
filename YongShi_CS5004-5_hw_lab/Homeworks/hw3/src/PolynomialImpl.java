/**
 * test class for impl on my polynomial operations.
 * @author Yong Shi
 * @since 2021.6.25
 */
public class PolynomialImpl implements Polynomial {
    // Only need the head as the member varialbe.
    private Node head;
    // creates an empty linked list.
    public PolynomialImpl() {
    }
    // creates getHead when traverse on the other polynomial.
    public Node getHead() {
        return head;
    }

    /**
     * addTerm method. basic algorithm is:
     * traverse to the last node and put the new node there with coe and pow.
     */
    @Override
    public Polynomial addTerm(int coe, int pow) {
        if (pow < 0) {
            throw new IndexOutOfBoundsException("pow can not be <0 in this assignment");
            // pow can not be <0 in this assignment.
        }
        int term[] = new int[2];
        term[0] = coe;
        term[1] = pow;
        if (head == null) {
            head = new Node(term, null);
            return this;
        }
        Node traversePtr = head;
        while(traversePtr.next != null) {
            // we keep traversing when the .next is not null.
            // jump to the next node.
            traversePtr = traversePtr.next;
        }
        // when we reach here, traversePtr is pointing to the last node of the linked list.
        // put the new node at .next.
        traversePtr.next = new Node(term, null);
        return this.sort(); // directly sort it to make the terms order.
    }

    /**
     * removeTerm method. basic algorithm is:
     * traverse to the node the pow is, and jump to link to next node from previous node.
     */
    @Override
    public Polynomial removeTerm(int pow) {
        if (pow < 0 || head == null) {
            throw new IndexOutOfBoundsException("pow can not be <0 in this assignment or this is an empty polynomial");
            // pow can not be <0 in this assignment.
        }
        Node traversePtr = head;
        Node prevPtr = null;
        while(pow != traversePtr.getPow()) {
            // before we jump to the next node, set the 'prevPtr' to point to the current node.
            prevPtr = traversePtr;
            // jump to the next node.
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
        // jump the current, means previous link to next.
        prevPtr.next = traversePtr.next;
        return this;
    }

    /**
     * getDegree method. although after sorted, can return the first term;
     * but here use traverse way can use for non order list, basic algorithm is:
     * traverse to all node and during that when compare 2 nodes, use high take the high pow one.
     */
    @Override
    public int getDegree() {
        if (head == null) {
            throw new IndexOutOfBoundsException("this is an empty polynomial"); // empty.
        }
        Node high = head;
        Node traversePtr = head;
        while (traversePtr.next != null) {
            if (high.getPow() < traversePtr.next.getPow()) {
                high = traversePtr.next; // use high take the high pow one.
            }
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return high.getPow();
    }

    /**
     * getCoe method, basic algorithm is:
     * traverse to all node till find the pow we want, and use high to take it.
     * also remind that if pow<0 or can not find the pow, throw exception.
     */
    @Override
    public int getCoefficient(int pow) {
        if (pow < 0 || head == null) {
            throw new IndexOutOfBoundsException("pow can not be <0 in this assignment or this is an empty polynomial");
            // pow can not be <0 in this assignment.
        }
        Node high = head;
        Node traversePtr = head;
        while (traversePtr!= null && pow != traversePtr.getPow()) {
            // keep traverse down if not find it till the last node.
            // use high to take the current node, the find one when jump out while loop.
            high = traversePtr.next;
            // jump to the next node.
            traversePtr = traversePtr.next;
        }
        if (high == null) {
            throw new IndexOutOfBoundsException();} // if there is no the same pow, throw exception.
        return high.getCoe();
    }

    /**
     * evaluate method, basic algorithm is:
     * traverse to all node and math them, and add each term to give the polynomial result.
     */
    @ Override
    public double evaluate(double num) {
        if (head == null) {
            return 0.0; // empty.
        }
        double res = 0;
        Node traversePtr = head;
        while (traversePtr != null) {
            // traverse all the nodes.
            // math them and add on to the result.
            res = res + traversePtr.getCoe()*Math.pow(num, traversePtr.getPow());
            // jump to the next node.
            traversePtr = traversePtr.next;
        }
        return res;
    }

    /**
     * add in another polynomial method, basic algorithm is:
     * select polynomial one the first node, traverse the other polynomial each node to find the same pow, add the coe.
     * then select polynomial one the 2nd node, traverse the other polynomial each node to find the same pow, add the coe.
     * then select polynomial one the next node, so eventually this is one more traverse. So use two while loop to do.
     */
    @Override
    public Polynomial add(Polynomial other) {
        if (head == null) {
            return other; // if polynomial one is 0, return the other one directly.
        }
        // first while loop to traverse the polynomial one.
        Node traversePtr = head;
        while (traversePtr != null) {
            // another while loop to traverse the other polynomial.
            Node traversePtrOther = other.getHead();
            while (traversePtrOther != null) {
                // get the same pow and add the coe together.
                if (traversePtr.val[1]==traversePtrOther.val[1]) {
                    traversePtr.val[0] = traversePtr.val[0] + traversePtrOther.val[0];
                }
                // the other polynomial jump to next node.
                traversePtrOther = traversePtrOther.next;
            }
            // the polynomial one jump to next node.
            traversePtr = traversePtr.next;
        }
        return this;
    }

    /**
     * this is my helper method for the sort to give the addTerm terms in order. Basic algorithm is:
     * use traversePtr as head position, index to traverse from the 2nd node to the end,
     * if index find pow > head pow, swap with head; index continue on and swap if index find higher pow.
     * this eventually get the head with highest pow. this is one while loop.
     * then moving on traversePtr to next position, index to traverse from the next node to the end,
     * so in this way get the 2nd node with 2nd highest pow... this is another one while loop.
     * this is a typical selection sorting algorithm.
     */
    public Polynomial sort() {
        if (head == null) {
            throw new IndexOutOfBoundsException("this is an empty polynomial"); // empty.
        }
        int temp1[] = new int[2]; // temp1[] to store the val with coe and pow.
        Node traversePtr = head;
        while (traversePtr != null) {
            // first while loop to track the position, which need swap in if index find higher pow node.
            Node index = traversePtr.next;
            while (index != null) {
                // in side while loop for index to traverse all the next nodes to looking for higher pow node.
                if (traversePtr.val[1]<index.val[1]) {
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
        return this;
    }

    /**
     * just write here for size, finally I did not use it.
     */
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
     * toString with 9 situations, due to first term no need "+"; last term no need space" "; -coe no need "+".
     * 1 scenario: coe==0, no print.
     * 4 scenarios with coe>0: first term, mid term, last term, only one term.
     * 4 scenarios with coe<0: first term, mid term, last term, only one term.
     */
    @Override
    public String toString() {
        String res = "";
        Node traversePtr = head;
        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            String str = "";
            if (traversePtr.val[0]==0) {
                 str = "";
            }else {
                if (traversePtr.val[0] >0) {
                    if (traversePtr.val[1] != getDegree() && traversePtr.next != null) {
                        str = "+" + traversePtr.val[0] + "x^" + traversePtr.val[1] + " ";
                    } else {
                        if (traversePtr.val[1] == getDegree() && traversePtr.next != null) {
                            str = "" + traversePtr.val[0] + "x^" + traversePtr.val[1] + " ";
                        } else {
                            if (traversePtr.val[1] != getDegree() && traversePtr.next == null) {
                                str = "+" + traversePtr.val[0] + "x^" + traversePtr.val[1] + "";
                            } else {
                                if (traversePtr.val[1] == getDegree() && traversePtr.next == null) {
                                    str = "" + traversePtr.val[0] + "x^" + traversePtr.val[1] + "";
                                }
                            }
                        }
                    }
                } else {
                    if (traversePtr.val[1] != getDegree() && traversePtr.next != null) {
                        str = "" + traversePtr.val[0] + "x^" + traversePtr.val[1] + " ";
                    } else {
                        if (traversePtr.val[1] == getDegree() && traversePtr.next != null) {
                            str = "" + traversePtr.val[0] + "x^" + traversePtr.val[1] + " ";
                        } else {
                            if (traversePtr.val[1] != getDegree() && traversePtr.next == null) {
                                str = "" + traversePtr.val[0] + "x^" + traversePtr.val[1] + "";
                            } else {
                                if (traversePtr.val[1] == getDegree() && traversePtr.next == null) {
                                    str = "" + traversePtr.val[0] + "x^" + traversePtr.val[1] + "";
                                }
                            }
                        }
                    }
                }
        }
            res = res + str;
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return "\"" + res + "\""; // this assignment request to use " as quotation marks
    }

}
