package Model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BulletImpl implements Bullet {
    int x, y;
    int offset1 = 13;
    int offset2 = 50;
    // use offset to adjust bullet image location to match with my plane center

    String buImage = "src/images/bullet.png";

    //constructor for bullet
    public BulletImpl(int a, int b) {
        this.x=a;
        this.y=b;
    }

    //draw the bullet
    @Override
    public void drawBu(Graphics g) {
        Image bu=new ImageIcon(buImage).getImage();
        g.drawImage(bu, x-offset1, y-offset2, null);
    }

    //get and set x y
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

}
