package SnakeView;

import SnakeCommon.Coordinate;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SnakeGUIPanel extends JPanel {
  public SnakeGUIPanel() {
    // make the panel focusable so that it can react to keyboard inputs
    this.setFocusable(true);

    // Load the image from the internet
    try {
      apple_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/10addac51ca9ba16a3cc46fcb64ca250e5fb15c58c78530c2096bf2e4b503b7b/apple.png"));
      snake_head_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/32956f1c46253cf2ebb9a9c6519df3116fe8c4ca7167444c1312168fbb96873c/head.png"));
      snake_body_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/08b035cfbd798f6bb0e0f7eb680979285a2df1d51f9066d53707a4a0f79f88ac/dot.png"));
    } catch (Exception e) {
      System.out.println("url doesn't work");
    }
  }

  public void paint(boolean isGameOver, List<Coordinate> snakeLocation, Coordinate appleLocation) {
    this.isGameOver = isGameOver;
    this.snake_loc = snakeLocation;
    this.apple_loc = appleLocation;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (isGameOver) {
      // just paint a "Game Over" string
      g.drawString("Game Over", 180, 200);
    } else {
      // paint the apple
      g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);
      // paint the snake head
      g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);
      // paint the snake body
      for (int i = 1; i < snake_loc.size(); i++) {
        g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
      }
    }
  }

  private boolean isGameOver;
  private List<Coordinate> snake_loc;
  private Coordinate apple_loc;
  private Image apple_image;
  private Image snake_head_image;
  private Image snake_body_image;

}
