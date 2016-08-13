package Controller.Bombs;

import Controller.Colliable;
import Controller.CollsionPool;
import Controller.PlaneController;
import Controller.SingleController;
import models.GameObject;
import models.Lock;
import untils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public class LockController extends SingleController implements Colliable {
    private static final int SPEED_CLOCK = 2;
    public LockController(Lock gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        this.getGameVector().dy = SPEED_CLOCK;
    }

    public static LockController create(int x, int y) {
        return new LockController(new Lock(x,y), new ImageDrawer("resources/lock.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance.onFrezze(
                    gameObject.getX(),
                    gameObject.getY()
            );
            NotificationCenter.instance
                    .onBomExpode(gameObject.getX(), gameObject.getY());
            Utils.playSound("resources/Lock.wav", false);
            gameObject.destroy();
        }
    }
}
