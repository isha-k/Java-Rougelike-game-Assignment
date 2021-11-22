package game;

import edu.monash.fit2099.engine.*;
import game.actions.DeathAction;
import game.actions.DrinkEstusAction;
import game.enums.Abilities;
import game.enums.Type;
import game.interfaces.Resettable;
import game.interfaces.Soul;

import java.util.ArrayList;

//PLAYER CLASS:
public class Player extends Actor implements Soul, Resettable {

	private final Menu menu = new Menu();

	//VARIABLES:
	private ArrayList<Abilities> abilityList = new ArrayList<>(); //Holds player abilities
	private static Type playerType = Type.PLAYER;  //Tells game this actor is player
	private int estusCharges = 3;
	private int soulCount = 0;
	private Location lastRestLocation;    		   //Previously last bonfire (goes to upon death)
	private ArrayList <Bonfire> activeBonfires = new ArrayList <Bonfire>(); //Array of lit bonfires

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.registerInstance();


		//ABILITIES:
		this.addCapability(Abilities.LIGHT);
		this.addCapability(Abilities.DRINK);
		this.addCapability(Abilities.DEATH);
		this.addCapability(Abilities.FALL);
		this.addCapability(Abilities.getVendor);
		this.addCapability(Abilities.TRAVEL);

		//MISC
		this.addCapability(Type.PLAYER);
	}

	/**
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
//		if(this.hasCapability(Status.VALLEY_DEATH)){
//			return new ResetAction();
//		}
		if(!this.isConscious()){
			return new DeathAction(this,map.locationOf(this));
		}

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		if (estusCharges > 0) {
			actions.add(new DrinkEstusAction());

			}
		//Display player stats each turn:
		System.out.println(displayStats());
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 *
	 * @param soulObject a target souls.
	 */
	@Override
	public void transferSouls(Soul soulObject) {
		//TODO: transfer Player's souls to another Soul's instance.
		//Upon death transfer all souls to TokenOfSouls object

	}

	/*
	*ALL Mutators work to set the variable listed in the player object.
	*/
	//MUTATORS:
	public void setName(String newName) {
		this.name = newName;
	}

	public void setDisplayChar(char newChar) {
		this.displayChar = newChar;
	}

	public void setHitPoints(int newInt) {     //REOCCURS IN ACTOR
		this.hitPoints = newInt;
	}

	public void setSoulCount(int num) {
		this.soulCount = num;
	}

	public void setEstusCharges(int num) {
		this.estusCharges = num;
	}

	public void decreaseEstusCharges(int num) {
		this.estusCharges = estusCharges - num;
	}

	public void increaseSoulCount(int num) {
		this.soulCount = soulCount + num;
	}

	@Override
	public boolean subtractSouls(int souls) {
		boolean successfulTransaction = false;
		this.soulCount = soulCount - souls;
		if(soulCount >= 0){
			successfulTransaction = true;
		}
		return successfulTransaction;
	}

	public void clearInventory() {
		inventory.clear();
	}

	public void setLastRestLocation(Location newLoc) {
		lastRestLocation = newLoc;
	}

	public void addBonfire(Bonfire bonfire) {
		activeBonfires.add(bonfire);
	}

	/*
	*ALL Accessors return the value listed from the player object.
	 */
	//ACCESSORS:
	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getSoulCount(){
		return soulCount;
	}

	public int getEstusCharges() {
		return estusCharges;
	}

	public Location getLastRestLocation() {    //Gets last visited bonfire for death reset
		return lastRestLocation;
	}

	public Location getBonfireLocation(int bonfireID) {
		Location returnLoc = activeBonfires.get(0).getLocation();

		for (int i = 0; i < activeBonfires.size(); i++) {    //Check previously lit bonfires

			int checkID = activeBonfires.get(i).getID();     //Compare ID of bonfires
				if (checkID == bonfireID) {
					returnLoc = activeBonfires.get(i).getLocation();  //Get location to travel to (bonfire with matching ID)
				}
				else {
					returnLoc = activeBonfires.get(0).getLocation(); //Else travel to first bonfire
				}

		}
		return returnLoc;
	}

	public int countActiveBonfires() {          //Counts how many bonfires the player has lit
		return activeBonfires.size();
	}

	public String getActiveBonfireName(int num) {     //Get specific bonfire name (Not Used anymore)
		return activeBonfires.get(num).getName();
	}

	/**
	 * @return Player stats to screen
	 */
	public String displayStats() {
		return "\nPlayer Stats: " +
				"\nHealth: " + getHitPoints() + "/" + getMaxHitPoints() +
				"\nEstus Charges: " + getEstusCharges() +
				"\nSouls: " + getSoulCount() +
				"\n";
	}


	@Override
	public void resetInstance() {
		this.hitPoints = maxHitPoints;
		this.estusCharges = 3;

	}

	@Override
	public boolean isExist() {
		return true;
	}
}
