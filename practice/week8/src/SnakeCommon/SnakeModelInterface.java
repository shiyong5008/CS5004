package SnakeCommon;

import java.util.List;

public interface SnakeModelInterface {
  List<Coordinate> getSnakeLocation();
  Coordinate getAppleLocation();
  boolean isGameOver();
  // Kick the model to recompute the location of
  // the snake (depending on the input direction)
  // and possibly the apple.
  void run(int direction);
}
