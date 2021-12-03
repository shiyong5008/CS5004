package SnakeView;

import SnakeCommon.Coordinate;
import SnakeCommon.SnakeModelInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeMockModel implements SnakeModelInterface {
  public SnakeMockModel()
  {
    rnd = new Random();
  }

  @Override
  public List<Coordinate> getSnakeLocation() {
    // randomly generate snake loc for testing purpose
    List<Coordinate> snake = new ArrayList<>();
    snake.add(new Coordinate(150, 200));
    return snake;
  }

  @Override
  public Coordinate getAppleLocation() {
    int dot_size = 10;
    // randomly generate apple loc for testing purpose
    // Random location within the panel.
    int new_x = rnd.nextInt(400);
    int new_y = rnd.nextInt(400);
    // Round the location to dot_size.
    return new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
  }

  @Override
  public boolean isGameOver() {
    // randomly generate isGameOver
    int val = rnd.nextInt(400);
    return val % 2 == 0;
  }

  @Override
  public void run(int direction) {
    // do nothing.
  }

  private Random rnd;
}
