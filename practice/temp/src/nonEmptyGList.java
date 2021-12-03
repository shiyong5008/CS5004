
public class nonEmptyGList<G> implements GList<G> {
  G val;
  GList<G> innerList;

  public nonEmptyGList(G val, GList innerList) {
    this.val = val;
    this.innerList = innerList;
  }

  public nonEmptyGList(G val) {
    this.val = val;
    this.innerList = new emptyGList();
  }

  @Override
  public int size() {
    return 1 + innerList.size();
  }

  @Override
  public GList<G> add(G val) {
    innerList = innerList.add(val);
    return this;
  }

  @Override
  public String toString() {
    return this.val + " " + innerList.toString();
  }

  @Override
  public G getVal(int index) {
    if (index == 0) {
      return this.val;
    }
    return innerList.getVal(index-1);
  }

  @Override
  public GList getNext() {
    return this.innerList;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

//  @Override
//  public int find(G find) {
//    if (find != this.val) {
//      return this.innerList.find(find);
//    }
//    return innerList.size();
//  }

//  @Override
//  public int find(G find) {
//    int index = 0;
//    while (index < size() && find != getVal(index)) {
//      index++;
//    }
//    if (index < size()) {
//      return index;
//    }
//    return -1;
//  }

  @Override
  public int find(G find) {
    if (find == this.val) {
      return 0;
    }
    int k= innerList.find(find)+1;
    if (find == getVal(k)) {return k;}
    else {return -1;}
  }

  @Override
  public GList<G> remove(int index) {
    if (index == 0) {
      this.val= null;
      return this.innerList;
    } else {
      this.innerList = this.innerList.remove(index-1);
      return this;
    }
  }

//  //want to use total track the size but failed
//  @Override
//  public int total() {
//    int total = 0;
//    while (this.innerList.size()>1) {
//      total=total+1;
//      this.innerList = this.innerList.remove(this.innerList.size()-1);
//    }
//    return total+2;
//  }

//  @Override
//  public GList reverse() {
//    int index = size()-1;
//    GList listR = new emptyGList();
//    while (index >= 0) {
//      listR = listR.add(getVal(index));
//      index--;
//    }
//    return listR;
//  }

}
