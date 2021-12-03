
public class Test {
  public static void main(String[] args) {
    // test create, add, isEmpty, size, getVal, getNext
    GList<Integer> list1 = new emptyGList<>();
    System.out.println(list1.isEmpty()); //true

    list1 = list1.add(2);
    list1 = list1.add(4);
    list1 = list1.add(6);
    list1 = list1.add(8);

    System.out.println(list1); //2 4 6 8
    System.out.println(list1.size()); //4
    System.out.println(list1.isEmpty()); //false
    System.out.println(list1.getVal(2)); //6
    System.out.println(list1.getNext()); //4 6 8

    // print the index of the val of find
    System.out.println(list1.find(2)); //0
    System.out.println(list1.find(4)); //1
    System.out.println(list1.find(6)); //2
    System.out.println(list1.find(8)); //3
    System.out.println(list1.find(1)); //-1
    System.out.println(list1.find(3)); //-1

    // test remove
    System.out.println(list1=list1.remove(2)); //2 4 8
    System.out.println(list1=list1.remove(0)); //4 8
    System.out.println(list1); //4 8

  }
}
