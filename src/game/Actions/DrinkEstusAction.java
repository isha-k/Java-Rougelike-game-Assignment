package game.Actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Player;
import game.enums.Abilities;

public class DrinkEstusAction extends Action {

        //CONSTRUCTOR:
        public DrinkEstusAction() {

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

            if(actor.hasCapability(Abilities.DRINK)) {
                if (actor instanceof Player);
                    int estusNum = ((Player)actor).getEstusCharges();

                    if(estusNum > 0) {
                        ((Player)actor).decreaseEstusCharges(1);
                        actor.heal(40);

                        return actor + " drinks from the Estus Flask. " +
                                "40 points of health have been restored. \n" +
                                "Current HP: " + ((Player)actor).getHitPoints() + "/" + ((Player)actor).getMaxHitPoints()
                                + "\nEstus Flask Charges: " + ((Player)actor).getEstusCharges();
                    }
                    else {
                        return actor + "'s Estus Flask is empty! Return to the Firelink Shrine to refill.";
                    }
            }
            else {
                return null;
            }

        }

        /**
         *
         * @param actor The actor performing the action.
         * @return string
         */
        @Override
            public String menuDescription(Actor actor) {
                return actor + " drinks from their Estus Flask";
            }

        /**
         *
         * @return
         */
        @Override
        public Action getNextAction() {
                    return null;
                }

    }
