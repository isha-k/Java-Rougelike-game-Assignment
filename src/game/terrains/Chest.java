package game.terrains;

import edu.monash.fit2099.engine.*;
import game.actions.ChestActions;

public class Chest extends Ground{
//    TokenOfSouls tokenOfSouls = new TokenOfSouls(100);

    public Chest(){
        super('?');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return new Actions(new ChestActions(direction, location));
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}

