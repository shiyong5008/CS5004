import java.util.*;

public class Card implements Comparable<Card> {
    private Value value;
    private Suit suit;

    private static List<Card> deck = new ArrayList<Card>();

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    static {
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(value, suit));
            }
        }
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public static List<Card> getDeck() {
        return deck;
    }

    public String toString() {
        return value + " of " + suit;
    }

    public static String ranCard(){
        Random random=new Random();
//        int s = (int)(random.nextInt(4));
//        int v = (int)(random.nextInt(14));
        int ran = (int)(random.nextInt(deck.size()));
        return deck.get(ran) + "";
    }

    public static void bet() {
        Random random=new Random();
//        int s = (int)(random.nextInt(4));
//        int v = (int)(random.nextInt(14));
        int ran = (int)(random.nextInt(deck.size()));
        switch (deck.get(ran).getSuit()) {
            case Clubs:
                System.out.println("Clubs bet 100$");
                break;
            case Spades:
                System.out.println("Spades bet 200$");
                break;
            case Hearts:
                System.out.println("Hearts bet 300$");
                break;
            case Diamonds:
                System.out.println("Diamonds bet 400$");
                break;
            default:
                System.out.println("no bet");
        }
    }


    public static void main(String[] args) {

        /* comment out from lab9

        System.out.println("=====random pick up 10 cards print out====");
        for(int i=0; i<10; i++){
            System.out.println(ranCard());
        }
        System.out.println();

        System.out.println("=====bet base on card suit====");
        System.out.println("=====random pick up 10 cards====");
        for(int j=0; j<10; j++){
            bet();
        }
        System.out.println();

        System.out.println("=====create all 52 cards with final modify error, check screen shot====");
//        final List<Card> cards52 = getDeck();
//        cards52 = new ArrayList<>();

         */

        /**
         * lab10 A0, 26 letters and iterator practice
         */
        // print out 26 letters
        String upLetter26="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] upL26=upLetter26.split("");
        List<String> upList = Arrays.asList(upL26);
        LinkedList<String> list=new LinkedList<String>();
        for(String string : upList) {
            if(string!=null&&!"".equals(string)){
                list.add(string);
            }
        }
        for(Iterator it = list.iterator(); it.hasNext();) {
            String str = (String) it.next();
            System.out.print(str+" ");
        }
        System.out.println();

        // remove A E I O U, and print letter left
        for(Iterator it = list.iterator(); it.hasNext();) {
            String str = (String) it.next();
            if(str.equals("A") || str.equals("E") || str.equals("I") || str.equals("O") || str.equals("U")){
                it.remove();
            }
        }
        for(Iterator it = list.iterator(); it.hasNext();) {
            String str = (String) it.next();
            System.out.print(str+" ");
        }
        System.out.println();

        /**
         * lab10 A1, compactor practice
         */
        // tests on the compareTo
        Card diamondAce = new Card(Value.ACE, Suit.Diamonds);
        Card clubTwo = new Card(Value.TWO, Suit.Clubs);
        System.out.println(diamondAce.compareTo(clubTwo) > 0); // true

        Card diamondAce2 = new Card(Value.ACE, Suit.Diamonds);
        Card clubTwo2 = new Card(Value.TWO, Suit.Clubs);
        System.out.println(diamondAce2.compareTo(clubTwo2) < 0); // false

        Card diamondAce3 = new Card(Value.ACE, Suit.Diamonds);
        Card diamondJack3 = new Card(Value.JACK, Suit.Diamonds);
        System.out.println(diamondAce3.compareTo(diamondJack3) > 0); // true

        Card diamondAce4 = new Card(Value.ACE, Suit.Diamonds);
        Card diamondJack4 = new Card(Value.JACK, Suit.Diamonds);
        System.out.println(diamondAce4.compareTo(diamondJack4) < 0); // false

        Card diamondAce5 = new Card(Value.ACE, Suit.Diamonds);
        Card diamondAce52 = new Card(Value.ACE, Suit.Diamonds);
        System.out.println(diamondAce5.compareTo(diamondAce52) == 0); // true
    }

    // compareTo and helper methods
    @Override
    public int compareTo(Card o) {
        if(this.compareSuit() == o.compareSuit()) {
            if(this.compareValue() == o.compareValue()) {
                return 0;
            }else if(this.compareValue() > o.compareValue()) {
                return 1;
            }else if(this.compareValue() < o.compareValue()) {
                return -1;
            }
        }else if(this.compareSuit() > o.compareSuit()) {
            return 1;
        }else if(this.compareSuit() < o.compareSuit()) {
            return -1;
        }
        return -9999;
    }

    public int compareSuit() {
        int flag;
        switch(getSuit()) {
            case Spades:
                flag = 24;
                break;
            case Hearts:
                flag = 23;
                break;
            case Diamonds:
                flag = 22;
                break;
            case Clubs:
                flag = 21;
                break;
            default:
                throw new IllegalArgumentException("wrong Suit");
        }
        return flag;
    }

    public int compareValue() {
        int flag;
        switch(getValue()) {
            case ACE:
                flag = 14;
                break;
            case KING:
                flag = 13;
                break;
            case QUEEN:
                flag = 12;
                break;
            case JACK:
                flag = 11;
                break;
            case TEN:
                flag = 10;
                break;
            case NINE:
                flag = 9;
                break;
            case EIGHT:
                flag = 8;
                break;
            case SEVEN:
                flag = 7;
                break;
            case SIX:
                flag = 6;
                break;
            case FIVE:
                flag = 5;
                break;
            case FOUR:
                flag = 4;
                break;
            case THREE:
                flag = 3;
                break;
            case TWO:
                flag = 2;
                break;
            default:
                throw new IllegalArgumentException("wrong Value");
        }
        return flag;
    }

}
