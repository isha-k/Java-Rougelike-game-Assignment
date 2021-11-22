package game.Actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.ResetManager;
import game.enums.Abilities;
import game.enums.Type;

public class ResetAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();

        if(actor.hasCapability(Type.PLAYER)){
            Location location = new Location(map,38, 12);
            map.moveActor(actor, location);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "resets";
    }
}
