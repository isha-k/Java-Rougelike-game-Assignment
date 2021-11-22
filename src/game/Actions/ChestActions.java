package game.actions;

import edu.monash.fit2099.engine.*;
import game.enemies.Enemy;
import game.interfaces.Soul;

import java.util.Random;

public class ChestActions extends Action {
    private Random random = new Random();
//    TokenOfSouls tokenOfSouls = new TokenOfSouls(100);
    private String direction;
    private Location chestLocation;

    public ChestActions(String direction, Location chestLocation){
        this.direction = direction;
        this.chestLocation = chestLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
       if(random.nextBoolean()){ //if return
           chestLocation.addActor(new Enemy("Mimic", "M", ) {
               @Override
               public void transferSouls(Soul soulObject) {

               }

               @Override
               public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
                   return null;
               }
           }
           return actor + " faces Mimic!!!";
       }
       else{

       }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
