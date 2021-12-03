package SnakeCommon;

import SnakeModel.SnakeBasicModel;
import SnakeView.SnakeGUIVIew;
import SnakeView.SnakeMockModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SnakeController implements ActionListener {
  public SnakeController(boolean isReplay) {
    if (isReplay) {
      gameInput = new RecordFileReader("./records/rec1.txt");
    } else {
      gameInput = new KeyBoardHandler();
    }
    model = new SnakeBasicModel();
    //model = new SnakeMockModel();
    view = new SnakeGUIVIew(gameInput);
    // set up the alarm, which fires periodically (16 ms == 60fps).
    // Every time it fires, we update the apple's location and repaint it.
    new Timer(200, this).start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String input = gameInput.getInput();
    // decode the input
    // split the record
    String[] tokens = input.split(" ");
    if (tokens.length == 1) {
      // only getting direction
      direction = Integer.parseInt(tokens[0]);
    } else {
      // getting both direction and apple location
      direction = Integer.parseInt(tokens[0]);
      appleLoc = new Coordinate(Integer.parseInt(tokens[1]),
          Integer.parseInt(tokens[2]));
    }

    model.run(direction);
    if (tokens.length == 1) {
      view.paint(model.isGameOver(), model.getSnakeLocation(), model.getAppleLocation());
    } else {
      view.paint(model.isGameOver(), model.getSnakeLocation(), appleLoc);
    }
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      // normal play mode
      new SnakeController(false);
    } else if (args[0].equals("replay")) {
      // replay mode
      new SnakeController(true);
    }
  }

  private int direction;
  private SnakeModelInterface model;
  private SnakeViewInterface view;
  private GameInput gameInput;
  private Coordinate appleLoc;
}
