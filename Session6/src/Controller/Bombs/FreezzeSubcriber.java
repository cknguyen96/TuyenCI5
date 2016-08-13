package Controller.Bombs;

import models.GameObject;

/**
 * Created by PhamTuyen on 8/13/2016.
 */
public interface FreezzeSubcriber {
    void onFrezze(int x, int y);
    GameObject getGameObject();
}
