package game.enemies;
import edu.monash.fit2099.engine.*;
import game.AttackAction;
import game.FollowBehaviour;
import game.enums.Status;
import game.enums.Type;
import game.interfaces.Behaviour;
import game.interfaces.Soul;

import java.util.*;

public abstract class Enemy extends Actor implements Soul {
    //    private ArrayList<Behaviour> behaviours = new ArrayList<>();
    private HashMap<Integer, Behaviour> behaviour = new HashMap<Integer, Behaviour>();
    private Random rand = new Random();
    int soulCount;
    FollowBehaviour followBehaviour;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints, int soulCount) {
        super(name, displayChar, hitPoints);
        this.soulCount = soulCount;
    }


    /**
     * Method checks the actions the actor can take and adds the available actions
     * @param actions - collection of possible actions for actor
     * @param enemy - the enemy
     * @param map -  the map containing the actors
     *
     */
    //the action of all enemies
    public void addAction(Actions actions, Actor enemy, GameMap map){
        Location location = map.locationOf(this);
        boolean isPlayer;
        MoveActorAction resultMove;

        for(Exit exit: location.getExits()){
            Location path = exit.getDestination();
            if(map.isAnActorAt(path)){   //if actor at destination / TargetActorInRange() method implementation
                Actor actor = map.getActorAt(path);
                isPlayer = actor.hasCapability(Type.PLAYER);  //check if actor at destination is Player Unkindled

                if(isPlayer){
                    actions.add(new AttackAction(enemy, actor));  //attack player if in range of enemy
                    behaviour.put(2, new FollowBehaviour(actor));
                }
            }
            else {  //else, if enemy can enter, enemy moves
                Ground ground = map.getGround(location);
                if(ground.canActorEnter(enemy)) {
                    resultMove = new MoveActorAction(location, exit.getName(), exit.getHotKey());
                }
                else {
                    resultMove = null;
                }
                actions.add(resultMove);
            }
            actions.add(new DoNothingAction()); //do nothing if both if statements are not satisfied
        }
    }

    /**
     * Determines if Enemy attacks Player.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        followBehaviour = new FollowBehaviour(otherActor);
        behaviour.put(2, followBehaviour);

        Actions actions = new Actions();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            if(followBehaviour == null){
                this.followBehaviour = new FollowBehaviour(otherActor);
                behaviour.put(2, this.followBehaviour);
            }
            actions.add(new AttackAction(this,direction));
        }


        return actions;
    }

    public Action playTurn(Actions actions, GameMap map, Display display) {
        // loop through all behaviours
        List<Map.Entry<Integer, Behaviour>> list = new LinkedList<Map.Entry<Integer, Behaviour>>(behaviour.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Behaviour>>() {

            @Override
            public int compare(Map.Entry<Integer, Behaviour> o1, Map.Entry<Integer, Behaviour> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry<Integer, Behaviour> item:list) {
            Action action = item.getValue().getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return actions.get(rand.nextInt(actions.size()));
    }

    /**
     * getter method returns the number of souls
     * @return number of souls actor has
     */
    public int getSoulCount() {
        return soulCount;
    }
}
