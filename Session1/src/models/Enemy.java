package models;

import java.util.Random;

/**
 * Created by PhamTuyen on 7/29/2016.
 */
public class Enemy {

    public int x;
    public int y;
    public Enemy(int x, int y){
        this.x += x;
        this.y += y;
    }
}
