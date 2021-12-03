package SnakeView;

import SnakeCommon.Coordinate;
import SnakeCommon.GameInput;
import SnakeCommon.KeyBoardHandler;
import SnakeCommon.SnakeViewInterface;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGUIVIew implements SnakeViewInterface {
  public SnakeGUIVIew(GameInput keyBoardHandler)
  {
    frame = new JFrame();
    panel = new SnakeGUIPanel();
    panel.setPreferredSize(new Dimension(400, 400));

    if (keyBoardHandler.isKeyBoard()) {
      // register the keyboard handler
      panel.addKeyListener((KeyListener) keyBoardHandler);
    }

    frame.add(panel);
    frame.pack();
    // by default, everything is invisible. Make it visible
    frame.setVisible(true);
  }

  @Override
  public void paint(boolean isGameOver, List<Coordinate> snakeLocation, Coordinate appleLocation) {
    panel.paint(isGameOver, snakeLocation, appleLocation);
  }

  private JFrame frame;
  private SnakeGUIPanel panel;
}
