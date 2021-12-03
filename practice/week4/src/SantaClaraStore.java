public class SantaClaraStore extends AbstractStore {
  @Override
  public void addBurger() {
    // price for burge is $5
    addSum(5);
    orderedFood.add(new Burger());
  }

  @Override
  public void addFries() {
    addSum(2);
    orderedFood.add(new Fries());
  }

  void specialFood() {
    // ...
  }

  public SantaClaraStore() {
    super();
  }
}
