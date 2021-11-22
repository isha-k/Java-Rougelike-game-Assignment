package game.enemies;
import edu.monash.fit2099.engine.*;
import game.GameWeaponItem;
import game.WanderBehaviour;
import game.enemies.Enemy;
import game.enums.Abilities;
import game.enums.Type;
import game.interfaces.Behaviour;
import game.interfaces.Soul;
import java.util.ArrayList;
import java.util.Random;

public class Skeleton extends Enemy {

    public static final char skeletonChar = 'S';
    private ArrayList<Behaviour> behaviours = new ArrayList<>();
    GameWeaponItem BroadSword = new GameWeaponItem("BroadSword", 'B', 30, "slashes", 80);
    GameWeaponItem GiantAxe = new GameWeaponItem("GiantAxe", 'A', 50, "cuts", 80);

    /**
     * Constructor: Makes a Skeleton Object and adds WanderBehaviour, Follow Capability and Weapon.
     * @param name the name of the Enemy
     */
    public Skeleton(String name) {
        super("Skeleton", skeletonChar, 100, 250);
        behaviours.add(new WanderBehaviour());
        this.addCapability(Abilities.FOLLOW);
        this.addCapability(Type.SKELETON);
        this.withRandomWeapon();
    }

    /**
     * Determines the weapon Skeleton will hold based off a random number generator to decide between BroadSword
     * or GiantAxe.
     */
    public void withRandomWeapon(){
        GameWeaponItem weapon;
        int damage;
        Random random = new Random();
        int randomInt = random.nextInt(2);
        if (randomInt == 0){
            weapon = BroadSword;
            BroadSword.addCapability(Abilities.CRITICALSTRIKE);
            if(BroadSword.chanceToHit() <= 20){
                damage = BroadSword.getDamage();
                BroadSword.setDamage(damage*2);
            }
        }
        else{
            weapon = GiantAxe;
            GiantAxe.addCapability(Abilities.SPINATTACK);
        }
        addItemToInventory(weapon);
    }


    /**
     * Determines the action of the Enemy.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        //check follow capability

//        // loop through all behaviours
//        for(game.interfaces.Behaviour Behaviour : behaviours) {
//            Action action = Behaviour.getAction(this, map);
//            if (action != null)
//                return action;
//        }

        super.addAction(actions, this, map);
        return super.playTurn(actions, map, display);
    }

    /**
     * Transfer the souls of dead Enemy to Player.
     * @param soulObject a target souls.
     */
    @Override
    public void transferSouls(Soul soulObject) {
    }

    public String toString(){
        return name + " has " + this.getWeapon();
    }
}
