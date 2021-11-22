package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.Bonfire;
import game.Player;
import game.enums.Abilities;

public class LightBonfireAction extends Action {

    //VARIABLES:
    private String direction;
    private Location bonfireLocation;
    private Bonfire bonfire;


    /**
     * @param direction
     * @param bonfireLocation
     * @param bonfireInput
     */
    //CONSTRUCTOR:
    public LightBonfireAction(String direction, Location bonfireLocation, Bonfire bonfireInput) {
        this.direction = direction;
        this.bonfireLocation = bonfireLocation;
        this.bonfire = bonfireInput;
    }

    //MUTATORS:


    /**
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return      Menu description
     * The execute function records the Bonfire lit in Player and gives the
     * player the required abilities to travel to and from each bonfire as
     * well as rest at that bonfire.
     */
    //OVERIDES:
    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        ((Player)actor).setLastRestLocation(location);      //Sets players last bonfire location
        String bonfireName = bonfire.getName();             //Get bonfire name
        bonfire.setLit(1);                                  //Set Bonfire to lit
        actor.addCapability(Abilities.REST);                //Allows player to use REST ability
        String abilityName;                                 //Enum to add

        if (bonfireName.substring(0, 1) == "a") {           //Check bonfire name (starts with a)
            abilityName = bonfireName.substring(0, 4);       //Grab "Anor" if name starts with a
        }
        else {
            abilityName = bonfireName.substring(4, 8);      //Else grab characters 4 to 8 from name
        }

        abilityName = abilityName.toUpperCase();            //Convert character to uppercase
        abilityName = "TRAVEL" + "_" + abilityName;         //Add enum format
        actor.addCapability(Abilities.valueOf(abilityName));//Add enum to player
        ((Player)actor).addBonfire(bonfire);                //Adds bonfire location to player's active bonfires
        return actor + " has lit " + bonfireName + ".";     //Returns menu output

    }

    /**
     * @param actor The actor performing the action.
     * @return      Screen output
     */
    @Override
    public String menuDescription(Actor actor) {
        String bonfireName = bonfire.getName();
        return actor + " lights nearby bonfire. [" + bonfireName + "]" ;
    }

    //ACCESSORS:




}
