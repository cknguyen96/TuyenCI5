package Controller.Enemy;

import Controller.SingleController;
import models.GameObject;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public class ZiczacPlaneTpye implements FLyBehavior {
    private static final  int SPEED = 3;
    @Override
    public void doShotFly(SingleController enemycontroller) {
        GameObject gameObject = enemycontroller.getGameObject();
        if(enemycontroller.getGameVector().dx >= 0){
            enemycontroller.getGameVector().dx = SPEED;
            enemycontroller.getGameVector().dy = SPEED;
        }
        if(enemycontroller.getGameObject().getX() > 400 ){
            enemycontroller.getGameVector().dx = -SPEED;
        }
        if(enemycontroller.getGameObject().getX() < 100){
            enemycontroller.getGameVector().dx = SPEED;
        }
    }
}
