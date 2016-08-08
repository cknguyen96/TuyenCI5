package Controller;

import models.GameObject;
import models.Pump;
import views.GameDrawer;
import views.ImageDrawer;

import java.util.Iterator;

/**
 * Created by PhamTuyen on 8/8/2016.
 */
public class PumpController extends SingleController implements Colliable {
    public final  static int SPEED = 3;
    public PumpController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            this.getGameObject().destroy();
        }
        Iterator<SingleController> singleControllerIterator = EnemyControllerManager.instance.getSingleControllerVector().iterator();
        while (singleControllerIterator.hasNext()){
            SingleController enemyController = singleControllerIterator.next();
            enemyController.gameObject.destroy();
        }
    }
}


