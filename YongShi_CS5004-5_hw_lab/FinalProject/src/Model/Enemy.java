package Model;

import java.awt.*;

public interface Enemy {
    //draw the enemy
    void drawPlane(Graphics g);

    //get set x y
    int getX();

    void setX(int x);

    int getY();

    void setY(int y);
}
