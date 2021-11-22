package game.Actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.MeleeWeapon;
import game.Player;
import game.enums.Abilities;

public class PurchaseAction extends Action {
    private Actor player;
    private MeleeWeapon weapon;
    public PurchaseAction(Actor player, MeleeWeapon weapon){
        this.player = player;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String menuPhrase = " does not have enough souls.";
        String weaponAsString = "";

        if (player.hasCapability(Abilities.getVendor)) {
            if (((Player)player).subtractSouls(weapon.getPrice())) {  //subtractSouls return true, player equips broadsword
                ((Player)player).clearInventory();
                player.addItemToInventory(weapon);  //ADD weapon to inventory
                weaponAsString = weapon.toString();
                menuPhrase = " equips a " + weaponAsString +"  from Vendor";
            }
        }
        return player + menuPhrase;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + weapon.getName() + " from Fire Keeper";
    }

}
