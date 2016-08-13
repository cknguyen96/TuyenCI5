//package Controller.Enemy;
//
//import Controller.Colliable;
//import Controller.Enemy.EnemyBulletController;
//import Controller.Enemy.EnemyBulletControllerManager;
//import Controller.Enemy.EnemyController;
//import Controller.PlaneController;
//import models.Enemy;
//import models.EnemyBullet;
//import views.GameDrawer;
//import views.ImageDrawer;
//
//import java.awt.*;
//
///**
// * Created by PhamTuyen on 8/2/2016.
// */
//public class EnemyController2 extends EnemyController implements Colliable {
//    private final static int MOVEMENT_SPEED = 1;
//    private final static int SHOT_SPEED = 150;
//    private final static int BULLET_SPEED = 3;
//    private int count;
//
//    public EnemyController2(Enemy gameObject, GameDrawer gameDrawer) {
//        super(gameObject, gameDrawer);
//
//
//        this.gameVector.dx = MOVEMENT_SPEED ;
//        this.gameVector.dy = MOVEMENT_SPEED;
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        count ++;
//        if (count == SHOT_SPEED) {
//            EnemyBulletController enemyBulletController =
//                    new EnemyBulletController(
//                            new EnemyBullet( this.gameObject.getMiddleX() - EnemyBullet.SIZE / 2, this.gameObject.getBottom()),
//                            new ImageDrawer("resources/enemy_bullet.png")
//                    );
//            int dx = PlaneController.instance.getGameObject().getX() - gameObject.getX();
//            int dy = PlaneController.instance.getGameObject().getY() - gameObject.getY();
//
//            if (dy > 0) {
//                double ratio = Math.sqrt(dx * dx + dy * dy) / BULLET_SPEED;
//
//                enemyBulletController.getGameVector().dy = (int)(dy / ratio);
//                enemyBulletController.getGameVector().dx = (int)(dx / ratio);
//
//                EnemyBulletControllerManager.instance.add(enemyBulletController);
//            }
//
//        }
//
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        super.draw(g);
//    }
//
//    @Override
//    public void onCollide(Colliable colliable) {
//
//    }
//}
