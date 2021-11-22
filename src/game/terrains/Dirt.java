package game.terrains;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.Random;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	public Dirt() {
		super('.');
	}

/*	*//**
	 * Spawns a Skeleton Enemy on Dirt.
	 * @param location The location of the Ground
	 *//*
	@Override
	public void tick(Location location) {
		if (location.containsAnActor() == false) {
			//gen random number between 0 and 12
			Random rand = new Random();
			int randInt = rand.nextInt(13);

			if (randInt >= 4) {
				location.addActor(new Skeleton("Skeleton"));
			}
		}

	}*/
}
