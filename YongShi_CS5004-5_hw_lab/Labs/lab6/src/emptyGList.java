
public class emptyGList<G> implements GList<G> {
  @Override
  public int size() {
    return 0;
  }

  /*
  @Override
  public int total() {
    return 0;
  }
  */

  @Override
  public GList add(G val) {
    return new nonEmptyGList(val);
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public G getVal(int index) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public GList getNext() {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int find(G find) {
    return -1;
  }

  @Override
  public GList remove(int index) {
    throw new IndexOutOfBoundsException();
  }
}