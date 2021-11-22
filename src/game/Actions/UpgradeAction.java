package game.Actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Player;
import game.enums.Abilities;
import game.enums.Type;

public class UpgradeAction extends Action {
    public UpgradeAction(Actor player){
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String menuPhrase = " does not have enough souls.";

        if (actor.hasCapability(Abilities.getVendor)) {
            if (((Player)actor).subtractSouls(200)) {
                actor.increaseMaxHp(25);
                menuPhrase = " HP has increased by 25.";
            }
        }
        return actor + menuPhrase;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases a health upgrade from the Fire Keeper";
    }
}
