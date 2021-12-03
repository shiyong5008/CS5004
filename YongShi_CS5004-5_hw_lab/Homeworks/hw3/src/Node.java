/**
 * this is for the linklist node build.
 * @author Yong Shi
 * @since 2021.6.25
 */
public class Node {

    /**
     * for the polynomial val need sore 2 int, one is coe and one is pow.
     * and a pointer to point to next.
     */
    public int[] val;
    public Node next;

    public Node(int[] val, Node next) {
        this.val = val;
        this.next = next;
    }

    /**
     * put get and set to reserve later use incase.
     */
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

    /* // this is no need as toString in impl can cover all.
    @Override
    public String toString() {
        if (val[0]==0) {
            return "";
        }
        if (val[0]>0) {
            return " +"+val[0]+"x^"+val[1];
        }
        return " "+val[0]+"x^"+val[1];
    }
     */
}
