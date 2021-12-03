public class Node<E> implements Comparable<Node<E>> {
    public E val;
    public Node<E> next;

    public Node(E val, Node<E> next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val+"";
    }

    @Override
    public int compareTo(Node<E> o) {
        return (Integer) val-(Integer) o.val;
    }

//    public int getSc() {
//        return Run.getScore();
//    }
}
