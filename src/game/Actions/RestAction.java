package game.Actions;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.Bonfire;
import game.Player;
import game.enums.Abilities;

public class RestAction extends Action {

    private String direction;
    private Location bonfireLocation;
    private Bonfire bonfire;

    //CONSTRUCTOR:
    /**
     *
     * @param direction
     * @param bonfireLocation
     */
    public RestAction(String direction, Location bonfireLocation, Bonfire bonfireInput) {
        this.direction = direction;
        this.bonfireLocation = bonfireLocation;
        this.bonfire = bonfireInput;
    }

    //MUTATOR:

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return      String or NULL
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(actor.hasCapability(Abilities.REST)) {

            Location location = map.locationOf(actor);
            ((Player)actor).setLastRestLocation(location);      //Sets players last bonfire location

            int healPoints = ((Player)actor).getMaxHitPoints(); //Gets players max possible health
            actor.heal(healPoints);                             //Heals player to max health.
            ((Player)actor).setEstusCharges(3);                 //Refills estus flask charges
            return actor + " has rested. Their health and estus charges have been reset.";
        }
        else {
            return null;
        }
    }

    //MENU OUTPUT:

    /**
     * @param actor The actor performing the action.
     * @return      String
     */
    @Override
    public String menuDescription(Actor actor) {
        String bonfireName = bonfire.getName();
        return actor + " rests at nearby bonfire. [" + bonfireName + "]";
    }

}
