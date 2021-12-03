import java.util.function.Predicate;

public class NonEmptyLinkedList<T> implements MyListInterface<T> {
  T val;
  MyListInterface<T> innerList;

  public NonEmptyLinkedList(T val, MyListInterface innerList) {
    this.val = val;
    this.innerList = innerList;
  }

  public NonEmptyLinkedList(T val) {
    this.val = val;
    this.innerList = new EmptyLinkedList();
  }

  @Override
  public int size() {
    return 1 + innerList.size();
  }

  @Override
  public MyListInterface<T> add(T val) {
    innerList = innerList.add(val);
    return this;
  }

  @Override
  public String toString() {
    return this.val + " " + innerList.toString();
  }

  @Override
  public T get(int index) {
    if (index == 0) {
      return this.val;
    }
    return innerList.get(index-1);
  }

  @Override
  public MyListInterface<T> remove(int index) {
    if (index == 0) {
      return this.innerList;
    } else {
      this.innerList = this.innerList.remove(index-1);
      return this;
    }
  }

  @Override
  public MyListInterface<T> subList(Predicate<T> cond) {
    if (cond.test(val) == false) {
      // discard 'val'
      return this.innerList.subList(cond);
    } else {
      // keep 'val'
      innerList = innerList.subList(cond);
      return this;
    }
  }
}
