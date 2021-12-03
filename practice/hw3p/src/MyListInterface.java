import java.util.function.Predicate;

public interface MyListInterface<T> {
  int size();
  MyListInterface add(T val);
  T get(int index);
  MyListInterface remove(int index);
  MyListInterface subList(Predicate<T> cond);
}
