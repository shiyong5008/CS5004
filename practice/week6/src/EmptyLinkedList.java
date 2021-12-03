import java.util.function.Predicate;

public class EmptyLinkedList<T> implements MyListInterface<T> {
  @Override
  public int size() {
    return 0;
  }

  @Override
  public MyListInterface add(T val) {
    return new NonEmptyLinkedList(val);
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public T get(int index) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public MyListInterface remove(int index) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public MyListInterface subList(Predicate<T> cond) {
    return this;
  }
}