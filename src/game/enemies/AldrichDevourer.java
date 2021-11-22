package game.enemies;

import edu.monash.fit2099.engine.*;
import game.DarkmoonLongbow;
import game.actions.DeathAction;
import game.enums.Abilities;
import game.interfaces.Resettable;
import game.interfaces.Soul;

public class AldrichDevourer extends Enemy implements Soul, Resettable {
    public static final char AldrichChar = 'A';
    /**
     * Constructor.
     *
     * @param name
     */
    public AldrichDevourer(String name) {
        super(name, AldrichChar, 350, 5000);

        //ADDS WEAPON TO AlDRICH
        Item longBow = new DarkmoonLongbow();
        longBow.addCapability(Abilities.RAGEMODE);
        addItemToInventory(longBow);
    }

    /**
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DoNothingAction
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        //check follow capability
        Location location = map.locationOf(this);
        actions.clear();

        if (!this.isConscious()) {
            actions.clear();
            System.out.println("ALDRICH THE DEVOURER HAS FALLEN");
            return new DeathAction(this, location);
        }

        if(this.hitPoints < 0.5*this.maxHitPoints) {
            this.addCapability(Abilities.EMBERMODE);
            System.out.println("ALDRICH EMBER MODE ACTIVATED");
        }

        super.addAction(actions, this, map);
        return super.playTurn(actions, map, display);
    }


    @Override
    public void transferSouls(Soul soulObject) {

    }

    @Override
    public void resetInstance() {
        this.hitPoints = maxHitPoints;
    }

    @Override
    public boolean isExist() {
        return true;
    }
}

