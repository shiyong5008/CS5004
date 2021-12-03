public class Node {
    // two things:
    // 1. val -- int
    public int[] val;
    // 2. a pointer, pointing to the next node
    // if there's no next, pointing to null
    public Node next;

    public Node(int[] val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getPow(){
        return val[1];
    }

    public int getCoe(){
        return val[0];
    }

    public void setPow(int pow){
        this.val[1] = pow;
    }

    public void setCoe(int coe){
        this.val[0] = coe;
    }

    @Override
    public String toString() {
        //return "[" + val[0] + "," + val[1] + "]"  + " ";
        return "("+val[0]+")"+"x^"+val[1]+"+";
    }
}
