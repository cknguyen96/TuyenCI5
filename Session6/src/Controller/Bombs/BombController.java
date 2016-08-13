package Controller.Bombs;

import Controller.Colliable;
import Controller.CollsionPool;
import Controller.PlaneController;
import Controller.SingleController;
import models.Bomb;
import models.GameObject;
import untils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public class BombController extends SingleController implements Colliable{
        private static final int SPEED_BOMB = 2;
    public BombController(Bomb gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        this.getGameVector().dy = SPEED_BOMB;
    }
    public static BombController create(int x, int y) {
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/pump.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {

            NotificationCenter.instance
                    .onBomExpode(gameObject.getX(), gameObject.getY());
            Utils.playSound("resources/explosion.wav", false);
            gameObject.destroy();
        }
    }
}
