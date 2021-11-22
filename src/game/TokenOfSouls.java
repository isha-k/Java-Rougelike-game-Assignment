package game;

import edu.monash.fit2099.engine.*;
//import game.Actions.GainSoulsAction;
import game.interfaces.Soul;

public class TokenOfSouls extends Item{

    //VARIABLES:
    int soulCount;
    protected Actor actor;
    protected Actor target;

    //CONSTRUCTOR:
    public TokenOfSouls(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
//        this.soulCount = souls;
    }
    public void addAction(Action action) {
        this.allowableActions.add(action);
    }

    //MUTATORS:
/*    public Actions allowableActions(Actor actor) {
        return new Actions(new Soul());
    }*/


    //ACCESSORS:
    public int getSoulCount() {                //Returns number of souls
        return soulCount;
    }

//    @Override
//    public void transferSouls(Soul soulObject) {
////        this.soulCount += soulObject;
//
//    }


    //INTERACTORS:
   //FIXME: THIS IS BROKEN
    /*
    public PickUpItemAction getPickUpAction(Actor actor) {
        if(portable){
            return new PickUpTokenOfSouls(this, soulCount);
        }
        return null;
    }*/





}
