package model;

public interface CrashInterface {
    // check bullet and enemy crash
    boolean Boom(Bullet z, Enemy d);

    //plane crash
    boolean Boom2(Enemy d, int x, int y);
}
