import java.util.ArrayList;

public abstract class AbstractStore implements InNOut {
  @Override
  public int checkOut() {
    return sum;
  }

  // Provide an accessor method for the child classes to modify
  // the private 'sum' member variable
  public void addSum(int inc) {
    sum += inc;
  }

  @Override
  public ArrayList<Edible> getFood() {
    return orderedFood;
  }

  public AbstractStore() {
    sum = 0;
    orderedFood = new ArrayList<>();
  }

  // Leave all the other methods to the concrete child classes to implement.

  private int sum;
  public ArrayList<Edible> orderedFood;
}
