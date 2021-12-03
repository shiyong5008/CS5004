public class Node<E> {
    public E val;
    public Node<E> next;

    public Node(E val, Node<E> next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
            return val + " ";
        }
}
