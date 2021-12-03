// One run of the game.
// You are allowed to make whatever change you want to this class.
public class Run implements Comparable<Run> {
  //private static int score;
  private int id; // the id of the gameplay
  private int score; // the score of this run

//  public int[] val;
//  public Run next;


  public Run(int id, int score) {
    this.id = id;
    this.score = score;
//    this.val[0] = id;
//    this.val[1] = score;
//    this.next = next;
  }

  public int getId() {
    return id;
  }
  public int getScore() {
    return score;
  }

  @Override
  public int compareTo(Run o) {
    return this.score - o.score;
  }

  public static int compare(Run o1, Run o2) {
    return o1.getScore()- o2.getScore();
  }
}
