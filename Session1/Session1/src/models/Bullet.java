package models;

/**
 * Created by PhamTuyen on 7/28/2016.
 */
public class Bullet {
    public int x;
    public int y;
    int dx;
    int dy;
    public  void moveTo(int x , int y){
        this.x = x ;
        this.y = y;
    }
}
