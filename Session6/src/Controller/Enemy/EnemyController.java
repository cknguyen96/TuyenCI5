package Controller.Enemy;

import Controller.*;
import Controller.Bombs.BombSubscriber;
import Controller.Bombs.FreezzeSubcriber;
import Controller.Bombs.NotificationCenter;

import models.Enemy;

import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public class EnemyController extends SingleController
implements Colliable,FreezzeSubcriber, BombSubscriber{

    public static final int SPEED = 3;
    private EnemyStage enemyState;
    private int frezzeCount;

    private int FREZZE_PERIOD = 200;

    private FrezzeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private CrossEnemyType crossEnemyType;
    private ZiczacPlaneTpye ziczacPlaneTpye;
    private StraightShotBehavior straightShotBehavior;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,
                           FrezzeBehavior freezeBehavior,
                           ShotBehavior shotBehavior, CrossEnemyType crossEnemyType, ZiczacPlaneTpye ziczacPlaneTpye
            ,StraightShotBehavior straightShotBehavior) {
        super(gameObject, gameDrawer);

        //this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
        NotificationCenter.instance
                .subsribe(this);
        NotificationCenter.instance
                .subsribeFrezze(this);
        enemyState = EnemyStage.NORMAL;
        this.freezeBehavior = freezeBehavior;
        this.shotBehavior = shotBehavior;
        this.crossEnemyType = crossEnemyType;
        this.ziczacPlaneTpye = ziczacPlaneTpye;
        this. straightShotBehavior = straightShotBehavior;
    }

    public EnemyStage getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyStage enemyState) {
        this.enemyState = enemyState;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof BulletController){
            this.gameObject.destroy();
        }
    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_3.png"),
                        new FrezzeBehavior(200), null,null,
                        new ZiczacPlaneTpye(),
                        new StraightShotBehavior());
                break;
            case WHITE:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_3.png"),
                        new FrezzeBehavior(300),
                        new FollowShotBehavior(),
                    new CrossEnemyType(),null,null);
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }

    @Override
    public void run() {

        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZZED:
                break;
        }

        if (freezeBehavior != null)
            freezeBehavior.run(this);
        if(shotBehavior != null)
            shotBehavior.doShot(this);
        if(crossEnemyType != null){
            crossEnemyType.doShotFly(this);
        }
        if(straightShotBehavior != null){
            straightShotBehavior.doShot(this);
        }
        if(ziczacPlaneTpye != null){
            ziczacPlaneTpye.doShotFly(this);
        }
    }

    @Override
    public void onFrezze(int x, int y) {
        enemyState = EnemyStage.FREZZED;
        frezzeCount = 0;
    }
}
