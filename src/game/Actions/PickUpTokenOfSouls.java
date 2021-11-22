package game.Actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.Player;

public class PickUpTokenOfSouls extends Action {

    protected Item item;
    protected int soulCount;

    //CONSTRUCTOR:
    public PickUpTokenOfSouls(Item item, int soulCount) {
        this.item = item;
        this.soulCount = soulCount;

    }


    //MUTATORS:

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return  menuDescription
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(item);

        int playerSouls = ((Player)actor).getSoulCount();
        int newPlayerSouls = playerSouls + soulCount;

        ((Player)actor).setSoulCount(newPlayerSouls);

        return menuDescription(actor);
    }

    //ACCESSORS:

    /**
     *
     * @param actor The actor performing the action.
     * @return String
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + item + "." +
                actor + " has gained " + soulCount + " souls.";
    }


}
