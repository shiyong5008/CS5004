public class MyListImplR<T> {
  T val;
  MyListImplR<T> innerList;

  public MyListImplR<T> returnMyself() {
    return this;
  }

  // Constructor to create a single node linked list.
  public MyListImplR(T val) {
    this.val = val;
    this.innerList = null;
  }

  public int size() {
    if (innerList == null) {
      return 1;
    }
    int sizeOfInner = innerList.size();
    return 1 + sizeOfInner;
  }

  //public MyListImplR subList(int fromIndex, int toIndex) {
  //}

  public MyListImplR remove(int index) {
    if (index == 0) {
      // return my inner linked list, essentially discarding my 'val'
      return innerList;
    } else {
      innerList = innerList.remove(index-1);
      // return myself (both my 'val' and my inner linked list)
      return this;
    }
  }

  public T get(int index) {
    if (index == 0) {
      // base case
      return val;
    } else {
      return innerList.get(index-1);
    }
  }

  public boolean add(T val) {
    if (innerList == null) {
      // I don't have an inner linked list,
      // so I haven to add 'val' myself
      innerList = new MyListImplR(val);
      return true;
    }
    return innerList.add(val);
  }

  @Override
  public String toString() {
    if (innerList == null) {
      // I'm a single-node linked list, i.e., I don't have an inner linked list
      // So just return my 'val'
      return val + " ";
    }
    //return this.val + " " + innerList.toString();
    String fromInnerList = innerList.toString();
    // Concatenate the string from the inner list with the string of my 'val;
    return this.val + " " + fromInnerList;
  }
}
