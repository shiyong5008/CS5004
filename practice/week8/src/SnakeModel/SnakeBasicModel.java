package SnakeModel;

import SnakeCommon.Coordinate;
import SnakeCommon.SnakeModelInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeBasicModel implements SnakeModelInterface {

  public SnakeBasicModel() {
    isGameOver = false;

    rnd = new Random();
    // Init the location of the apple
    appleLoc = new Coordinate(200, 200);
    // Init the location of the snake.
    // It starts with head only
    // The list head is the snake head.
    // Assume the radius of each dot is 10.
    snakeLoc = new ArrayList<>();
    snakeLoc.add(new Coordinate(50, 50));
    snakeLoc.add(new Coordinate(50 + dot_size, 50));
    snakeLoc.add(new Coordinate(50 + 2 * dot_size, 50));
  }

  @Override
  public List<Coordinate> getSnakeLocation() {
    return snakeLoc;
  }

  @Override
  public Coordinate getAppleLocation() {
    return appleLoc;
  }

  @Override
  public void run(int direction) {
    // We update the snake's location.
    // Make it look like the snake is moving forward
    // Trick: move the tail to become the new head,
    // and keep other nodes the same
    // 1. chop off the tail
    Coordinate old_tail = snakeLoc.remove(snakeLoc.size()-1);
    // TODO: what if size is 1
    // 2. get the loc of the old head
    int old_head_x = snakeLoc.get(0).x;
    int old_head_y = snakeLoc.get(0).y;
    // 3. add a new head. The loc of the new head
    // depends on the direction of movement
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;
    if (direction == 1) {
      // up
      new_head_y -= dot_size;
    } else if (direction == 2) {
      // down
      new_head_y += dot_size;
    } else if (direction == 3) {
      // left
      new_head_x -= dot_size;
    } else if (direction == 4) {
      // right
      new_head_x += dot_size;
    }
    Coordinate new_head = new Coordinate(new_head_x, new_head_y);
    snakeLoc.add(0, new_head);

    // collision detection
    if (new_head_x < 0 || new_head_x > 400 ||
        new_head_y < 0 || new_head_y > 400) {
      // hit the wall
      isGameOver = true;
    }

    for (int i = 1; i < snakeLoc.size(); i++) {
      if (snakeLoc.get(i).equals(new_head)) {
        // hit the snake body
        isGameOver = true;
      }
    }

    // check whether the head overlaps with the apple
    if (snakeLoc.get(0).equals(appleLoc)) {
      // eating the apple.
      // Increase size by 1.
      // Added the removed tail back.
      snakeLoc.add(old_tail);

      // also need to regenerate the apple's location
      regenApple();
    }
  }

  private void regenApple() {
    // Random location within the panel.
    int new_x = rnd.nextInt(400);
    int new_y = rnd.nextInt(400);
    // Round the location to dot_size.
    appleLoc = new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
  }

  @Override
  public boolean isGameOver() {
    return isGameOver;
  }

  private Random rnd;
  private int dot_size = 10;
  private List<Coordinate> snakeLoc;
  private Coordinate appleLoc;
  private boolean isGameOver;
}
