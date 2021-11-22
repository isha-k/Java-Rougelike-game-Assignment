package game.Actions;

import edu.monash.fit2099.engine.*;
import game.TokenOfSouls;
import game.enums.Abilities;
import game.enums.Status;
import game.enums.Type;

public class DeathAction extends Action{

    protected Actor currentActor;
    protected Location location;
    protected String hotKey;

    //CONSTRUCTOR:

    /**
     *
     * @param actor
     * @param location
     */
    public DeathAction(Actor actor, Location location) {
        this.currentActor = actor;
        this.location = location;
        this.hotKey = null;
    }

    /**
     *
     * @param actor
     * @param map
     * @return String
     */
    public String execute(Actor actor, GameMap map) {
//        if(actor.hasCapability(Status.VALLEY_DEATH)) {
//            Item souls = new TokenOfSouls("Souls", '$', true);
//            map.at(this.location.x() -1, this.location.y() -1).addItem(souls);
//
//            Location location = new Location(map, 38, 12);
//            map.moveActor(actor,location);

        if(!actor.hasCapability(Abilities.RANDOM)){
            Item souls = new TokenOfSouls("Souls", '$', true);
            map.at(this.location.x() -1, this.location.y() -1).addItem(souls);

        }
        map.removeActor(actor);

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " dies";
    }

    /**
     * Returns this Action's hotkey.
     *
     * @return the hotkey
     */
    @Override
    public String hotkey() {
        return hotKey;
    }
}

