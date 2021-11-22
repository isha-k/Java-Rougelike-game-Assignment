package game.enemies;

import edu.monash.fit2099.engine.*;
import game.GreatMachete;
import game.Actions.DeathAction;
import game.enemies.Enemy;
import game.enums.Abilities;
import game.interfaces.Soul;

public class LordOfCinder extends Enemy {
    public static final char YhormChar = 'Y';

    /**
     * Constructor.
     */
    public LordOfCinder(String name) {
        super("Lord Of Cinder", YhormChar, 500, 5000);

        //ADDS WEAPON TO YHORM
        Item greatMachete = new GreatMachete();
        greatMachete.addCapability(Abilities.RAGEMODE);
        addItemToInventory(greatMachete);
    }

    /**
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DoNothingAction
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        //check follow capability
        Location location = map.locationOf(this);
        actions.clear();

        if (!this.isConscious()) {
            actions.clear();
            System.out.println("LORD OF CINDER HAS FALLEN");
            return new DeathAction(this, location);
        }

        if(this.hitPoints < 0.5*this.maxHitPoints) {
            this.addCapability(Abilities.RAGEMODE);
            System.out.println("YHORM EMBER MODE ACTIVATED");
        }

        super.addAction(actions, this, map);
        return super.playTurn(actions, map, display);
    }


    //NOT USED
    @Override
    public void transferSouls(Soul soulObject) {

    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(95, "burns");
    }

    //FIXME: This will be created when Yhorm is defeated.
    //LordOfCinder.addItemToInventory(new PortableItem("Cinders of a Lord", '*', 9000))

}


