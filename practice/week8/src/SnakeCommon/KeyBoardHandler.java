package SnakeCommon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardHandler implements KeyListener, GameInput {
  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      // up key is pressed
      direction = 1;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      // down
      direction = 2;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      // left
      direction = 3;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // right
      direction = 4;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // do nothing
  }

  public String getInput() {
    return Integer.toString(direction);
  }

  @Override
  public boolean isKeyBoard() {
    return true;
  }

  private int direction = 1;
}
