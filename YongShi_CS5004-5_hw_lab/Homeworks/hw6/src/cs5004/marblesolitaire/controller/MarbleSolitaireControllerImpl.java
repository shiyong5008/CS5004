package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is the controller implementation for readable and appendable.
 * @author Yong Shi
 * @since 2021-7-26
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController{
    public Readable rd;
    public Appendable ap;

    /**
     * constructor with readable and appendable
     * @param rd
     * @param ap
     */
    public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) {
        if (rd == null || ap == null) {
            throw new IllegalArgumentException("input or output is null");
        }
        this.rd = rd;
        this.ap = ap;
    }

    /**
     * this is the main part of this hw for playGame execution
     * @param model
     * @throws IOException
     */
    @Override
    public void playGame(MarbleSolitaireModel model) throws IOException {
        if (model == null) {
            throw new IllegalArgumentException("model is null");
        }
        if (rd == null || ap == null) {
            throw new IllegalStateException("input or output is null");
        }

        /**
         * while loop with flag1 to make the game ongoing and
         * I would like to print out the current moveCount and remind quit game in this loop
         * for quit will print out the game quit, the game state and current score
         */
        int fromX, fromY, toX, toY;
        String quit="";
        int flag1 = 1;
        int moveCount = 0;
        Scanner scan = new Scanner(this.rd);
        while (flag1 == 1) {
            this.ap.append("Current moveCount is "+moveCount+". Game ongoing..." + System.lineSeparator() +
                    "pls press \"q\" to quit; or any other key to continue:" + System.lineSeparator());
            quit = scan.next();
            if (quit.equals("q") || quit.equals("Q")) {
                this.ap.append("Game quit!" +System.lineSeparator() +"State of game when quit:" +System.lineSeparator());
                this.ap.append(model.getGameState() +  System.lineSeparator() + "Score:" + model.getScore());
                flag1 =0;
                // break;
                // System.exit(99);
            } else { // if game over at this point, just move to print game over format
                if (model.isGameOver()) {
                    this.ap.append("Game Over!\n");
                    this.ap.append(model.getGameState() + "\nScore:" + model.getScore());
                    // flag1 = 0;
                    break;
                }

                /**
                 * while loop with flag2 is to handle the move from x,y input,
                 * to make sure got correct input, for other wrong input, will remind and
                 * asking for correct input, until user hit q or Q to quit the game
                 */
                int flag2 = 2;
                while (flag2 == 2) {
                // Scanner scan = new Scanner(this.rd);
                    this.ap.append("pls input from x(1 is the first row) or \"q\" to quit:");
                    while (true) {
                        try {
                            fromX = scan.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            String wrong = scan.next();
                            if (wrong.equals("q") || wrong.equals("Q")) {
                                this.ap.append("Game quit!\nState of game when quit:\n");
                                this.ap.append(model.getGameState() + "\nScore:" + model.getScore());
                                flag1 = 0;
                                flag2 = 0;
                                // break;
                                System.exit(99);
                            } else {
                                this.ap.append("Game ongoing, pls input int from x(1 is the first row) or \"q\" to quit:");
                            }
                        }
                    }
                    this.ap.append("pls input from Y(1 is the first col) or \"q\" to quit:");
                    while (true) {
                        try {
                            fromY = scan.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            String wrong = scan.next();
                            if (wrong.equals("q") || wrong.equals("Q")) {
                                this.ap.append("Game quit!\nState of game when quit:\n");
                                this.ap.append(model.getGameState() + "\nScore:" + model.getScore());
                                flag1 = 0;
                                flag2 = 0;
                                // break;
                                System.exit(99);
                            } else {
                                this.ap.append("Game ongoing, pls input int from y(1 is the first col) or \"q\" to quit:");
                            }
                        }
                    }
                    if (!(model.canMove(fromX-1, fromY-1))) {
                        this.ap.append("invalid move from (" + fromX + "," + fromY + ")\n");
                        flag2 = 2;
                    } else if (model.canMove(fromX-1, fromY-1)) {

                        /**
                         * while loop with flag3 is to handle to x,y data, and remind
                         * user to input valid move to position. also will continue ask for
                         * correct to position, until user hit q or Q to quit game
                         */
                        int flag3 = 3;
                        while (flag3 == 3) {
                            this.ap.append("pls input to x(1 is the first row) or \"q\" to quit:");
                            while (true) {
                                try {
                                    toX = scan.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    String wrong = scan.next();
                                    if (wrong.equals("q") || wrong.equals("Q")) {
                                        this.ap.append("Game quit!\nState of game when quit:\n");
                                        this.ap.append(model.getGameState() + "\nScore:" + model.getScore());
                                        flag1 = 0;
                                        flag3 = 0;
                                        // break;
                                        System.exit(99);
                                    } else {
                                        this.ap.append("Game ongoing, pls input int to x(1 is the first row) or \"q\" to quit:");
                                    }
                                }
                            }
                            this.ap.append("pls input to Y(1 is the first col): or \"q\" to quit:");
                            while (true) {
                                try {
                                    toY = scan.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    String wrong = scan.next();
                                    if (wrong.equals("q") || wrong.equals("Q")) {
                                        this.ap.append("Game quit!\nState of game when quit:\n");
                                        this.ap.append(model.getGameState() + "\nScore:" + model.getScore());
                                        flag1 = 0;
                                        flag3 = 0;
                                        // break;
                                        System.exit(99);
                                    } else {
                                        this.ap.append("Game ongoing, pls input int to y(1 is the first col) or \"q\" to quit:");
                                    }
                                }
                            }

                            /**
                             * here is to check if the to position is valid. logic is
                             * that from position already checked valid, so to position just
                             * to check if the to position is over the from position
                             */
                            if (!((toX == fromX + 2 && toY == fromY)
                                    || (toX == fromX - 2 && toY == fromY)
                                    || (toX == fromX && toY == fromY + 2)
                                    || (toX == fromX && toY == fromY - 2))) {
                                this.ap.append("invalid move to (" + toX + "," + toY + ")\n");
                                flag3 = 3;
                            } else if ((toX == fromX + 2 && toY == fromY)
                                    || (toX == fromX - 2 && toY == fromY)
                                    || (toX == fromX && toY == fromY + 2)
                                    || (toX == fromX && toY == fromY - 2)) {
                                model.move(fromX-1, fromY-1, toX-1, toY-1);
                                moveCount++;
                                flag3 = 0;
                                // break;
                            }
                        }
                        flag2 = 0;
                        // break;
                    }
                }
            }

            /**
             * after the move, check if game over, and print accordingly and exit
             */
            if (model.isGameOver()) {
                this.ap.append("Game Over!\n");
                this.ap.append(model.getGameState() + "\nScore:" + model.getScore());
                flag1 = 0;
                // break;
                System.exit(99);
            }
        }
    }
}
