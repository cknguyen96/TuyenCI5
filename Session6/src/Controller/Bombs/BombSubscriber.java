package Controller.Bombs;

import models.GameObject;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public interface BombSubscriber {
    public void onBombExplode(int x, int y);
    public GameObject getGameObject();
}
