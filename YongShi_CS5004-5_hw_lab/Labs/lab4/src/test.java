public class test {

    // just test for the new method for the odd and even words
    public static void main(String[] args) {
        Node n6 = new Node("mark", null);
        Node n5 = new Node("tom", n6);
        Node n4 = new Node("prof", n5);
        Node n3 = new Node("hi", n4);
        Node n2 = new Node("world", n3);
        Node n1 = new Node("hello", n2);

        SListImpl list = new SListImpl(n1);

        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.oddWords());
        System.out.println(list.evenWords());
    }
}
