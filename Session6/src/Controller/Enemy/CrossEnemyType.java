package Controller.Enemy;

import Controller.SingleController;
import models.GameObject;
import models.GameVector;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public class CrossEnemyType implements FLyBehavior {
    private static final int SPEED = 2;
    @Override
    public void doShotFly(SingleController enemycontroller) {
        GameObject gameObject = enemycontroller.getGameObject();
        enemycontroller.getGameVector().dy = SPEED;
        enemycontroller.getGameVector().dx = -SPEED;
    }
}
