package SnakeCommon;

import java.util.List;

public interface SnakeViewInterface {
  void paint(boolean isGameOver, List<Coordinate> snakeLocation, Coordinate appleLocation);
}
