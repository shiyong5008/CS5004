public class test {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedListImpl<Integer>(4);
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

        TopScoreTracker tracker = new TopScoreTrackerImpl(2, 5);
        tracker.addRun(1, new Run(4, 12));
        tracker.addRun(1, new Run(4, 13));
        System.out.println(tracker);
    }
}
