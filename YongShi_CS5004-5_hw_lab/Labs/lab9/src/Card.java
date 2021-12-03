import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
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
    }

}
