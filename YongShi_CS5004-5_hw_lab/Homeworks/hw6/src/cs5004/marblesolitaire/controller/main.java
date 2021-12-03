package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {
        MarbleSolitaireController ctrl =
                new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),System.out);
        try {
            ctrl.playGame(new MarbleSolitaireModelImpl());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
