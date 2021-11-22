package game;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.LightBonfireAction;
import game.RestAction;
import game.enums.Abilities;

public class Bonfire extends Ground {

    //VARIABLES:
    String name;
    int lit;
    int ID;
    Location location;

    //CONSTRUCTOR:
    public Bonfire(String newName, Location location, int ID) {
        super('B');
        this.name = newName;
        this.lit = 0;
        this.location = location;
        this.ID = ID;
    }

    //ACCESSORS:

    /**
     *
     * @param actor the Actor to check
     * @return      - True if actor can enter
     */
    @Override
    public boolean canActorEnter(Actor actor){
        return true;
    }

    /**
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return          - New actions to actor
     *
     * If player has been to previous bonfires and lit them, give player action to travel to them from other bonfire.
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){

        if (actor.hasCapability(Abilities.TRAVEL) && lit == 1) {

            Actions list = super.allowableActions(actor, location, direction);

            if (actor.hasCapability(Abilities.TRAVEL_FIRE)) {
                list.add(new MoveActorAction(((Player)actor).getBonfireLocation(101), "to The Firelink Shrine", "T"));
            }

            if (actor.hasCapability(Abilities.TRAVEL_FIER)) {
                list.add(new MoveActorAction(((Player)actor).getBonfireLocation(102), "to The Fiery Wastes", "Y"));
            }

            if (actor.hasCapability(Abilities.TRAVEL_GRAV)) {
                list.add(new MoveActorAction(((Player)actor).getBonfireLocation(103), "to Anor Londo' Bonfire", "U"));
            }

            if (actor.hasCapability(Abilities.TRAVEL_LOND)) {
                list.add(new MoveActorAction(((Player)actor).getBonfireLocation(104), "to The Graves", "I"));
            }

            return list;

            //ALTERNATE CODE FOR LISTING TRAVELS (BROKEN)
            /*
            int activeBonfires = ((Player)actor).countActiveBonfires();
            for (int i = 0; i < activeBonfires; i++) {
                int NID = 101 + i;
                String string = "to " + ((Player)actor).getActiveBonfireName(i);
                list.add(new MoveActorAction(((Player)actor).getBonfireLocation(NID), string, "T"));

                //return new Actions(new MoveActorAction(((Player)actor).getBonfireLocation(NID), string, "T"));
                return list;
            }
            */
        }
            //IF bonfire is not lit provide lightBonfireAction. If it is lit give restAction
        if (actor.hasCapability(Abilities.LIGHT) && lit == 0) {
            return new Actions(new LightBonfireAction(direction, location, this));
        }
        else {
            return new Actions(new RestAction(direction, location, this));
        }

    }

    /**
     * @param num Set bonfire as lit or not
     */
    //MUTATORS:
    public void setLit(int num) {
        lit = num;
    }


    /**
     * @return name of bonfire
     */
    //ACCESSORS:
    public String getName() {
        return name;
    }

    /**
     * @return Whether bonfire is lit
     */
    public int getLit() {
        return lit;
    }

    /**
     * @return Location of Bonfire
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return Bonfire unique identifier
     */
    public int getID() {
        return ID;
    }


}
