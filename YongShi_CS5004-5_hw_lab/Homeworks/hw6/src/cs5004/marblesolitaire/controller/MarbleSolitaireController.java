package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

import java.io.IOException;

/**
 * this is the interface of the controller
 */
public interface MarbleSolitaireController {
    void playGame(MarbleSolitaireModel model) throws IOException;
}
