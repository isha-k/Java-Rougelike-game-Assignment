package game.enemies;

import edu.monash.fit2099.engine.*;
import game.interfaces.Resettable;
import game.interfaces.Soul;

public class Mimic extends Enemy implements Resettable, Soul {
    protected IntrinsicWeapon weapon;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param soulCount
     */
    public Mimic(String name, char displayChar, int hitPoints, int soulCount) {
        super(name, displayChar, hitPoints, soulCount);
        this.weapon= new IntrinsicWeapon(100, "kick");
    }


    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        super.addAction(actions, this, map);
        return super.playTurn(actions, map, display);
    }

    @Override
    public void resetInstance() {
        this.hitPoints = maxHitPoints;
    }

    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public void transferSouls(Soul soulObject) {

    }
}
