package cs5004.marblesolitaire.model;

public interface MarbleSolitaireModel {
    void move(int fromRow, int fromColumn, int toRow, int toColumn);
    String getGameState();
    boolean isGameOver();
    int getScore();
    boolean canMove(int x, int y);
    String toString();
}
