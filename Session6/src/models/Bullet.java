package models;

/**
 * Created by PhamTuyen on 7/28/2016.
 */
public class Bullet extends GameObject {
    public int getDamage() {
        return damage;
    }

    public final static int WIDTH = 13;
    public final static int HEIGHT = 30;
    private int damage;
    public Bullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
