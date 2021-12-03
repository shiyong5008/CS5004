package MainFrame;

import javax.swing.*;

import panel.GamePanel;
public class GameMain {

    public static void main(String[] args) {

        int width = 400;
        int height = 650;
        String title = "CS5004ProjectYong";

        JFrame j = new JFrame(); //create window
        GamePanel g = new GamePanel(); //create panel
        j.add(g); //add panel
        j.setSize(width, height);
        j.setTitle(title); //title
        j.setLocationRelativeTo(null); //set at middle
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //set default close
        j.setVisible(true); //make visible
        g.Move(); //start the move
        j.addMouseListener(g); //mouse listener
        j.addMouseMotionListener(g); //mouse motion listener

    }

}
