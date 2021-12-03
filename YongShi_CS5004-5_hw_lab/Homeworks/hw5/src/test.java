public class test {
    public static void main(String[] args) {
        OrderedListImpl<Integer> list = new OrderedListImpl<Integer>(4);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(5);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(1);
        System.out.println(list);

        OrderedListImpl<Integer> listT = new OrderedListImpl<Integer>(4);
        listT.add(10);
        listT.add(20);
        listT.add(30);

        System.out.println(list.merge(listT));

//        list.print();

//        TopScoreTracker tracker = new TopScoreTrackerImpl(2, 5);

        OrderedListImpl<Run> list2 = new OrderedListImpl<Run>(4);
        list2.add(new Run(4, 12));
        list2.add(new Run(4, 13));
        list2.add(new Run(4, 15));
        list2.add(new Run(4, 17));
        list2.add(new Run(4, 11));
        list2.add(new Run(4, 10));
        System.out.println(list2);

        OrderedListImpl<Run> list3 = new OrderedListImpl<Run>(4);
        list3.add(new Run(4, 1));
        list3.add(new Run(4, 3));
        list3.add(new Run(4, 5));
        list3.add(new Run(4, 7));
        list3.add(new Run(4, 1));
        list3.add(new Run(4, 9));
        System.out.println(list3);

        System.out.println(list2.merge(list3));





    }
}
