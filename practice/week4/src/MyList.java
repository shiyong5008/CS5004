public interface MyList {
  boolean add(int val);
  int get(int index);
  boolean isEmpty();
  int remove(int index);
  int size();
  MyList subList(int fromIndex, int toIndex);
}
