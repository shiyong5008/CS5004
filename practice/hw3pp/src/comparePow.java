import java.util.Comparator;

public class comparePow implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        int name1 = o1.getPow();
        int name2 = o2.getPow();
        if (name1<name2) {return -1;}
        if (name1==name2) {return 0;}
        return 1;
    }
}
