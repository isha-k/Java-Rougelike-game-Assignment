package game.terrains;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import game.enums.Type;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		boolean isPlayer = false;
		if(actor.hasCapability(Type.PLAYER)){ //checking for player or enemy, so enemy can't enter
			isPlayer = true;
		}
		return isPlayer;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
