public class Node<T> {
  // two things:
  // 1. val -- int
  public T val;
  // 2. a pointer, pointing to the next node
  // if there's no next, pointing to null
  public Node<T> next;

  public Node(T val, Node<T> next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return " " + val + " ";
  }
}
