package Controller.Enemy;

import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public class StraightShotBehavior implements ShotBehavior {
    private final static int BULLET_SPEED = 3;
    private final static int SHOT_PERIOD = 100;

    private int count;
    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if(count >= SHOT_PERIOD ){
            count = 0;
            GameObject gameObject = enemyController.getGameObject();

            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(gameObject.getMiddleX() - EnemyBullet.SIZE / 2,
                            gameObject.getBottom()),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            enemyBulletController.getGameVector().dy = BULLET_SPEED;
            EnemyBulletControllerManager.instance.add(enemyBulletController);
        }
    }
}
