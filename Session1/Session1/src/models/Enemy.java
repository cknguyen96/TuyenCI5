package models;

import java.util.Random;

/**
 * Created by PhamTuyen on 7/29/2016.
 */
public class Enemy {

    Random rand = new Random();
    public int dx = rand.nextInt(600);
    public int dy = rand.nextInt(100);
    public  int x = rand.nextInt(650);
    public int  y;
    public void moveEnemy(int x, int y){
        this.x += dx;
        this.y += dy;
    }
}
