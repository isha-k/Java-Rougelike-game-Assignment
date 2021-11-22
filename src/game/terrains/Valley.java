package game.terrains;

import edu.monash.fit2099.engine.*;
import game.enums.Abilities;
import game.enums.Status;
import game.enums.Type;

/**
 * The gorge or endless gap that is dangerous for the Player.
 */
public class Valley extends Ground {

	private final Menu menu = new Menu();

	//CONSTRUCTOR:
	public Valley() {
		super('+');
	}

	//MUTATOR:

	/**
	 *
	 * @param actor the Actor to check
	 * @return      true if actor can enter
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Type.PLAYER);
	}

/*	*//**
	 *
	 * @param location The location of the Ground
//	 */
//	@Override
//	public void tick(Location location) {
//		Actor actor = location.getActor();
//		if(actor.hasCapability(Abilities.FALL)){
//			location.getActor().hurt(Integer.MAX_VALUE);
//		}
//	}

	/**
	 * Checks if Valley ground type contains Player, if true, hurt player and remove player.
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the Ground from the Actor
	 * @return
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		if(location.containsAnActor()){
			actor.hurt(Integer.MAX_VALUE);
			actor.addCapability(Status.VALLEY_DEATH);

			/*location.map().removeActor(actor);
			System.out.println("YOU HAVE FALLEN IN A VALLEY AND DIED.");
			location.map().addActor(actor, bonfireLocation);*/

			/*if(!actor.isConscious()){
				actor.asSoul();  //making actor a now soul object?
			}*/
			//location.map().removeActor(actor);
		}
		return new Actions();
	}


	//TOKEN OF SOULS IS SPAWNED ONE STEP BACK FROM VALLEY (previous player spot)
	//Token of Souls need to show up as $ on the map


}
