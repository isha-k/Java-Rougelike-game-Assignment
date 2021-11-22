package game.terrains;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import game.enums.Type;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {

	public Floor() {
		super('_');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		boolean isPlayer = false;
		if(actor.hasCapability(Type.PLAYER)){ //checking for player or enemy, so enemy can't enter
			isPlayer = true;
		}
		return isPlayer;
	}
}
