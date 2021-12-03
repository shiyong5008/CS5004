/**
 * This is going to implement the link list Node. For CS5004/5 lab5.
 *
 * @author  Yong Shi
 * @version 1.0
 * @since   2021-06-16
 */
public class TNode {
  // two things:
  // 1. val -- String
  public String val;
  // 2. a pointer, pointing to the next node
  // if there's no next, pointing to null
  public TNode next;

  public TNode(String val, TNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return val + " ";
  }
}
