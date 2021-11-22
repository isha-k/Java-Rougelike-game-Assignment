package game.terrains;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.enemies.Undead;

import java.util.Random;

/**
 * A class that represents Cemetery.
 */
public class Cemetery extends Ground {

    //CONSTRUCTOR:
    public Cemetery() {
        super('c');
    }


    /**
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            //gen random number between 0 and 10
            Random rand = new Random();
            int randInt = rand.nextInt(101);

            if (randInt > 75) {
                location.addActor(new Undead("Undead"));
            }
        }

    }



}
