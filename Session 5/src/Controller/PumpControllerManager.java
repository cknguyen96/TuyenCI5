package Controller;

import models.Pump;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by PhamTuyen on 8/8/2016.
 */
public class PumpControllerManager extends ControllerManager {
    private int count;
    private static final int RESPAWN_TYPE = 100;


    private PumpControllerManager() {
        super();
    }
    @Override
    public void run() {
        super.run();
        count++;
        if (count == RESPAWN_TYPE) {
            count = 0;
            Random random = new Random();
            int enX = random.nextInt(1000);
            int enY =  random.nextInt(1000);
            PumpController pumpController = new PumpController(
                    new Pump(enX, enY),
                    new ImageDrawer("resources/Pump.png")
            );
            this.add(pumpController);
        }

    }
    public final static PumpControllerManager instance = new PumpControllerManager();
}
