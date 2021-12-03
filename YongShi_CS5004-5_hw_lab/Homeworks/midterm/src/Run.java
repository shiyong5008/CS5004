// One run of the game.
// You are allowed to make whatever change you want to this class.
public class Run implements Comparable<Run> {
  private int id; // the id of the gameplay
  private int score; // the score of this run

  public Run(int id, int score) {
    this.id = id;
    this.score = score;
  }

  public int getScore() {
    return score;
  }
  public int getId() {
    return id;
  }

  @Override
  public int compareTo(Run o) {
    return this.score - o.getScore();
  }

  @Override
  public String toString() {
    return id +" "+ score + " ";
  }
}
