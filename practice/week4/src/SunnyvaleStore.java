public class SunnyvaleStore extends AbstractStore {
  @Override
  public void addBurger() {
    // the price of burger is $6
    addSum(6);
    orderedFood.add(new Burger());
  }

  @Override
  public void addFries() {
    addSum(3);
    orderedFood.add(new Fries());
  }

  public SunnyvaleStore() {
    super();
  }
}
