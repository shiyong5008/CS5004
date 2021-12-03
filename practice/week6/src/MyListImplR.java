public class MyListImplR {
  int val;
  MyListImplR innerList;

  // Constructor to create a single node linked list.
  public MyListImplR(int val) {
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

  // Remove nodes whose value is less 3
  public MyListImplR subList() {
    if (innerList == null) {
      if (this.val >= 3) {
        // we need to keep the current node
        return this;
      } else {
        // we want to remove the last node
        return null;
      }
    }
    this.innerList = this.innerList.subList();
    if (this.val >= 3) {
      // we need to keep the current node
      // return this
      return removeHead(false);
    } else {
      // we don't want to keep the current node/val
      //return this.innerList;
      return removeHead(true);
    }
  }

  // Helper method for removing the head (current node).
  // if doRemove is true, then do remove the head
  // else, don't remove the head
  public MyListImplR removeHead(boolean doRemove) {
    if (doRemove) {
      return this.innerList;
    } else {
      return this;
    }
  }

  public MyListImplR remove(int index) {
    if (index == 0) {
      // return my inner linked list, essentially discarding my 'val'
      //return innerList;
      return removeHead(true); // do want to remove the head
    } else {
      innerList = innerList.remove(index-1);
      // return myself (both my 'val' and my inner linked list)
      //return this;
      return removeHead(false); // don't want to remove the head
    }
  }

  public int get(int index) {
    if (index == 0) {
      // base case
      return val;
    } else {
      return innerList.get(index-1);
    }
  }

  public boolean add(int val) {
    if (innerList == null) {
      // I don't have an inner linked list,
      // so I don't have to add 'val' myself
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
    // Concatenate the string from the inner list with the string of my 'val';
    return this.val + " " + fromInnerList;
  }
}
