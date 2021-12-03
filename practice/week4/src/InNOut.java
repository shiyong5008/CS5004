import java.util.ArrayList;

// Menu for order food from In N Out
// If you want to really order some food, you have to go to an actual store
public interface InNOut {
  void addBurger();
  void addFries();
  int checkOut();
  // return all the food that you ordered
  ArrayList<Edible> getFood();
}
