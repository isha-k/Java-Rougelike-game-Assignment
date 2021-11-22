package game.enemies;


import edu.monash.fit2099.engine.*;
import game.WanderBehaviour;
import game.actions.DeathAction;
import game.enemies.Enemy;
import game.enums.Abilities;
import game.enums.Type;
import game.interfaces.Behaviour;
import game.interfaces.Resettable;
import game.interfaces.Soul;

import java.util.*;

/**
 * An undead minion.
 */
public class Undead extends Enemy implements Soul, Resettable {
	// Will need to change this to a collection if Undeads gets additional Behaviours.
//	private ArrayList<Behaviour> behaviours = new ArrayList<>();
	private HashMap<Integer, Behaviour> behaviour = new HashMap<Integer, Behaviour>();
	private int soulCount;

	/**
	 * Constructor.
	 * All Undeads are represented by an 'u' and have 30 hit points.
	 * @param name the name of this Undead
	 */
	public Undead(String name) {
		super(name, 'u', 50, 50);
		behaviour.put(3, new WanderBehaviour());
		this.addCapability(Type.UNDEAD);
		this.registerInstance();
	}

	/**
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the action to be performed
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		//check follow capability
		Location location = map.locationOf(this);
//		actions.clear();

		//gen random number between 0 and 10
		Random rand = new Random();
		int randInt = rand.nextInt(11);
		if (randInt == 1) {
			actions.clear();
			this.addCapability(Abilities.RANDOM);
			return new DeathAction(this, location);
		}

//		if(!this.isConscious()){
//			map.removeActor(this);
//		}

		super.addAction(actions, this, map);
		return super.playTurn(actions, map, display);
	}

	@Override
	public void transferSouls(Soul soulObject) {

	}

	@Override
	public void resetInstance() {
		this.followBehaviour = null;
		this.hitPoints = maxHitPoints;
		this.hurt(Integer.MAX_VALUE);
	}

	@Override
	public boolean isExist() {
		return true;
	}
}
