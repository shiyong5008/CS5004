public class OrderedListImplRun implements OrderedListRun{
    private NodeRun head;
    private int cap;

    public OrderedListImplRun(int capacity) {
        if (capacity<0) {
            throw new IllegalArgumentException("capacity should not less then zero");
        }
        this.head = null;
        this.cap = capacity;
    }

    public NodeRun getHead() {
        return head;
    }

    public int getCap() {
        return cap;
    }

    @Override
    public String toString() {
        String res = "";
        NodeRun traversePtr = head;

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

    /*
    // this is a sort method, just list here as at beginning I
    // wanted to use sort for help add. But that more complicated.
    public void sort() {
        if (head == null) {
            throw new IllegalArgumentException("this is an empty list");
        }
        NodeRunRun traversePtr = head;
        while (traversePtr != null) {
            // first while loop to track the position, which need swap in if index find higher val node.
            NodeRun index = traversePtr.next;
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
    public Run getMax() {
        NodeRun traversePtr = head;
        if (traversePtr == null) {
            return null;
        }
        while(traversePtr.next != null) {
            traversePtr = traversePtr.next;
        }
        return (Run)traversePtr.val;
    }
     */

    @Override
    public void addRunHelp(Run val) {
        if (head == null) {
            if (val==null) {throw new IllegalArgumentException("Run is null");}
            else if (val!=null) {
                head = new NodeRun(val, null);
            }
        } else if (head != null) {

            int k = 1;
            NodeRun preCheckLength = head;
            while (preCheckLength.next != null) {
                k++;
                preCheckLength = preCheckLength.next;
            }

      /* // no need these codes as to combine to below when head.next==null situation.
      if (head.next == null && (Integer)val > (Integer) head.val) {
        head.next = new Node (val, null);
      } else if (head.next == null && (Integer)val <= (Integer) head.val) {
        Node<E> temp = head;
        head = new Node (val, temp);
      }*/

            //int[] preHeadVal = head.val;
            boolean doneFlag = false;
            NodeRun traversePtr = head;
            NodeRun pre = new NodeRun (new Run(1,1), head);

            while (traversePtr != null) {
                int i = 1;
                NodeRun checkLength = head;
                while (checkLength.next != null) {
                    i++;
                    checkLength = checkLength.next;
                }
                if (val.getScore() <= traversePtr.val[1] && i<cap && traversePtr==head) {
                    NodeRun temp = head;
                    head = new NodeRun(val, temp);
                    doneFlag = true;
                    break;
                }else if (val.getScore() <= traversePtr.val[1] && i<cap && traversePtr!=head) {
                    pre.next = new NodeRun(val, traversePtr);
                    doneFlag = true;
                    break;
                }else if (val.getScore() <= traversePtr.val[1] && i==cap && traversePtr==head) {
                    doneFlag = true;
                    break;
                }else if (val.getScore() <= traversePtr.val[1] && i==cap && traversePtr!=head) {
                    pre.next = new NodeRun(val, traversePtr);
                    head = head.next;
                    doneFlag = true;
                    break;
                }
                traversePtr = traversePtr.next;
                pre = pre.next;
            }

            int j = 1;
            NodeRun postCheckLength = head;
            while (postCheckLength.next != null) {
                j++;
                postCheckLength = postCheckLength.next;
            }
            if (doneFlag == false && j==k && j<cap) {
                pre.next = new NodeRun(val, null);
            }else if (doneFlag == false && j==k && j==cap) {
                pre.next = new NodeRun(val, null);
                head = head.next;
            }
        }
    }

    @Override
    public OrderedListRun merge(OrderedListRun other) {
        int l1= cap;
        int l2 = other.getCap();

        int capNew = l1+l2;
        OrderedListRun<Run> list = new OrderedListImplRun(capNew);

        NodeRun traversePtr = head;
        while(traversePtr!= null) {
            list.addRunHelp(traversePtr.run);
            traversePtr = traversePtr.next;
        }
        NodeRun traversePtr2 = other.getHead();
        while(traversePtr2!= null) {
            list.addRunHelp((Run) traversePtr2.run);
            traversePtr2 = traversePtr2.next;
        }
        return list;
    }

    @Override
    public void resize(int newCapacity) {
        OrderedListRun<Run> list = new OrderedListImplRun(this.getCap());

        NodeRun traversePtr = head;
        while (traversePtr != null) {
            list.addRunHelp((Run)traversePtr.run);
            traversePtr = traversePtr.next;
        }

        NodeRun traversePtr2 = list.getHead();

        this.head.next = null;
        this.head = null;
        this.cap = newCapacity;

        while (traversePtr2 != null) {
            this.addRunHelp((Run)traversePtr2.run);
            traversePtr2 = traversePtr2.next;
        }
    }

    /*
    @Override
    public void addRunHelp(Run val) {
        if (head == null) {
            head = new Node(val, null);
        } else if (head != null) {

            int k = 1;
            Node preCheckLength = head;
            while (preCheckLength.next != null) {
                k++;
                preCheckLength = preCheckLength.next;
            }

            Run preHeadVal = head.val;
            boolean doneFlag = false;
            Node traversePtr = head;
            Node pre = new Node (0, head);

            while (traversePtr != null) {
                int i = 1;
                Node checkLength = head;
                while (checkLength.next != null) {
                    i++;
                    checkLength = checkLength.next;
                }
                if (Run.compare((Run)val, (Run)traversePtr.val)<=0 && i<cap && traversePtr==head) {
                    Node temp = head;
                    head = new Node(val, temp);
                    doneFlag = true;
                    break;
                }else if (Run.compare((Run)val, (Run)traversePtr.val)<=0 && i<cap && traversePtr!=head) {
                    pre.next = new Node(val, traversePtr);
                    doneFlag = true;
                    break;
                }else if (Run.compare((Run)val, (Run)traversePtr.val)<=0 && i==cap && traversePtr==head) {
                    doneFlag = true;
                    break;
                }else if (Run.compare((Run)val, (Run)traversePtr.val)<=0 && i==cap && traversePtr!=head) {
                    pre.next = new Node(val, traversePtr);
                    head = head.next;
                    doneFlag = true;
                    break;
                }
                traversePtr = traversePtr.next;
                pre = pre.next;
            }

            int j = 1;
            Node postCheckLength = head;
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
    */

}