package cs5004.marblesolitaire.model;

public class test {
    public static void main(String[] args) {
        MarbleSolitaireModelImpl g1 = new MarbleSolitaireModelImpl(3, 2, 4);
        System.out.println("======\n===g1:\n"+g1);
        g1.move(2,2, 2, 4);
        System.out.println("======\n==g1 after move:\n"+g1);
        System.out.println("======\n==g1 after move getScore:\n"+g1.getScore());
        System.out.println("======\n==g1 after move getGameState:\n"+g1.getGameState());
        System.out.println("======\n==g1 after move isGameOver:\n"+g1.isGameOver());

        MarbleSolitaireModelImpl g2 = new MarbleSolitaireModelImpl();
        System.out.println("======\n===g2:\n"+g2);

        MarbleSolitaireModelImpl g3 = new MarbleSolitaireModelImpl(2,2);
        System.out.println("======\n===g3:\n"+g3);

        MarbleSolitaireModelImpl g4 = new MarbleSolitaireModelImpl(5);
        System.out.println("======\n===g4:\n"+g4);

        MarbleSolitaireModelImpl g5 = new MarbleSolitaireModelImpl(5, 5, 5);
        System.out.println("======\n===g5:\n"+g5);
        System.out.println("======\n==g5 getScore:\n"+g5.getScore());

    }
}
