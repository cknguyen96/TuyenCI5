package models;

/**
 * Created by PhamTuyen on 8/8/2016.
 */
public class Bomb extends GameObject {
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    public Bomb(int x, int y) {
        super(x, y,  WIDTH, HEIGHT);
    }
}
