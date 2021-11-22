package game.terrains;

import edu.monash.fit2099.engine.*;
import game.enums.Type;

public class FogDoor extends Ground {

    //VARIABLES:
    Location targetLocation;

    //CONSTRUCTOR:
    public FogDoor(Location targetLocation) {
        super('=');
        this.targetLocation = targetLocation;

        /*
        targetLocation.x();
        targetLocation.y();
        targetLocation.map();
        */
    }

    /**
     *
     * @param actor the Actor to check
     * @return true because Actor enters to enter Anor Londo.
     */
    @Override
    public boolean canActorEnter(Actor actor){
        boolean isPlayer = false;
        if(actor.hasCapability(Type.PLAYER)){ //checking for player or enemy, so enemy can't enter
            isPlayer = true;
        }
        return isPlayer;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return new Actions(new MoveActorAction(targetLocation, "moves to next map", "F"));
    }
}
