
public class Test {
  public static void main(String[] args) {
    // test create, add, isEmpty, size, getVal, getNext, remove
    GList<Integer> list1 = new emptyGList<>();
    System.out.println(list1.isEmpty()); //true

    list1 = list1.add(1);
    list1 = list1.add(3);
    list1 = list1.add(5);
    list1 = list1.add(7);

    System.out.println(list1); //1 3 5 7
    System.out.println(list1.size()); //4
    System.out.println(list1.isEmpty()); //false
    System.out.println(list1.getVal(2)); //5
    System.out.println(list1.getNext()); //3 5 7
    System.out.println(list1.remove(0)); //3 5 7
    System.out.println(list1);
    System.out.println(list1.remove(1)); //3 7
    System.out.println(list1);

    // test find
    GList<Integer> list2 = new emptyGList<>();

    list2 = list2.add(2);
    list2 = list2.add(4);
    list2 = list2.add(6);
    list2 = list2.add(8);

    System.out.println(list2); //2 4 6 8
    //System.out.println(list2.reverse()); //8 6 4 2
    System.out.println(list2.size()); //4
    System.out.println(list2.find(2)); //0
    System.out.println(list2.find(4)); //1
    System.out.println(list2.find(6)); //2
    System.out.println(list2.find(8)); //3
    System.out.println(list2.find(1)); //-1
    System.out.println(list2.find(9)); //-1
  }
}
