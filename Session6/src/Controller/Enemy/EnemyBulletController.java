package Controller.Enemy;

import Controller.Colliable;
import Controller.PlaneController;
import Controller.SingleController;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by PhamTuyen on 8/8/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {
    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            colliable.getGameObject().destroy();
        }
    }
}
