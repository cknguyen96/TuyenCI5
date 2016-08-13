package Controller.Enemy;

/**
 * Created by PhamTuyen on 8/12/2016.
 */
public class FrezzeBehavior {
    private int count;
    private int frezzePeriod;
    public FrezzeBehavior( int frezzePeriod){
        this.frezzePeriod =  frezzePeriod;
        this.count = 0;
    }
    public  void run ( EnemyController enemyController){
        switch (enemyController.getEnemyState()){
            case NORMAL:
                break;
            case FREZZED:
                count++;
                if ( count > frezzePeriod ){
                    count = 0;
                    enemyController.setEnemyState(EnemyStage.NORMAL);
                }
        }
    }
}
