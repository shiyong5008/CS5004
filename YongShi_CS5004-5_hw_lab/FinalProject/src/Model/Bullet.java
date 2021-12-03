package Model;

import java.awt.*;

public interface Bullet {
    //draw the bullet
    void drawBu(Graphics g);

    //get and set x y
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);
}
