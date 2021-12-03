package model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullet {
    int x, y;
    int offset1 = 13;
    int offset2 = 50;
    // use offset to adjust bullet image location to match with my plane center

    String buImage = "src/images/bullet.png";

    //constructor for bullet
    public Bullet(int a, int b) {
        this.x=a;
        this.y=b;
    }

    //draw the bullet
    public void drawBu(Graphics g) {
        Image bu=new ImageIcon(buImage).getImage();
        g.drawImage(bu, x-offset1, y-offset2, null);
    }

    //get and set x y
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
