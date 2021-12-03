package model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy {
    int x,y;
    String icon;
    int offset1 = 0;
    int offset2 = 0;
    // offset reserve here incase when change enemy pics.

    public Enemy(String icon) { //para is enemy image location
        this.icon=icon;
        x=(int)(Math.random()*340)+10; //random on the x location 10-350
        y=-30; // and hard code them for now to make visual accept
    }

    //draw the enemy
    public void drawPlane(Graphics g) {
        Image plane=new ImageIcon(icon).getImage();
        g.drawImage(plane, x-offset1, y-offset2, null);
    }

    //get set x y
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
