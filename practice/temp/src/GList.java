
public interface GList<G> {
  int size();
  //int total();
  //GList reverse();

  GList add(G val);

  G getVal(int index);

  GList getNext();

  boolean isEmpty();

  int find(G find);

  GList remove(int index);
}
