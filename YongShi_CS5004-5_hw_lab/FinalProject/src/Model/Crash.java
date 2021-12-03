package Model;

public interface Crash {
    // check bullet and enemy crash
    boolean Boom(BulletImpl z, Enemy d);

    //plane crash
    boolean Boom2(Enemy d, int x, int y);
}
