package game;

import edu.monash.fit2099.engine.*;
import game.actions.PurchaseAction;
import game.actions.UpgradeAction;
import game.enums.Type;

public class Vendor extends Actor {

    //VARIABLES:


    //CONSTRUCTOR:

    /**
     * @param name      - Name of actor (vendor)
     * @param nChar     - Display char of actor (vendor)
     * @param hitPoints - Health of actor (vendor)
     */
    public Vendor(String name, char nChar, int hitPoints) {
        super(name, nChar, hitPoints);
        this.addCapability(Type.VENDOR);
    }

    //IMPLEMENTATION OF METHODS

    /**
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return - nothing
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return - list of actions
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions list = super.getAllowableActions(otherActor, direction, map);

        list.add(new PurchaseAction(otherActor, new MeleeWeapon("BroadSword", 's', 30, "slices", 80, 500)));
        list.add(new PurchaseAction(otherActor, new MeleeWeapon("GiantAxe", 'a', 50, "chops", 80, 1000)));
        list.add(new UpgradeAction(otherActor));

        return list;
    }
}
