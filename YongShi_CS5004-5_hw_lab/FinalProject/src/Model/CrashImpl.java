package Model;

public class CrashImpl implements Crash {

    // check bullet and enemy crash
    @Override
    public boolean Boom(BulletImpl z, Enemy d) {
        int zx, zy, dx, dy;
        boolean crash = false;

        //bullet location
        zx = z.getX();
        zy = z.getY();

        //enemy location
        dx = d.getX();
        dy = d.getY();

        if (zx-dx > 0 && zx-dx < 50 && zy - dy > 50 && zy - dy < 130) {
            //zx-dx>0 and <50, x touch;
            //zy - dy > 50 && zy - dy < 130, y touch.
            //and base on visible also can accept.
            crash = true; //if crash return true
        }
        return crash;
    }

    //plane crash
    @Override
    public boolean Boom2(Enemy d, int x, int y) {
        int dx, dy;
        boolean crash = false;

        //enemy location, no need offset, since enemy class now use offset 0
        dx = d.getX();
        dy = d.getY();

        //my location with pic size offset to get the visual x,y of my plane
        x = x - 25;
        y = y - 60;

        //crash
        if (dx - x > -30 && dx - x < 30 && y - dy < 0  && y - dy > -30) {
            // dx - x > -30 && dx - x < 30 x touch;
            // y - dy < 0  && y - dy > -30 y touch;
            // and base on visible also can accept.
            crash = true; //if crash return true
        }
        return crash;
    }

}
