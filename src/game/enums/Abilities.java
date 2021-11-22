package game.enums;

/**
 * Enum that represents an ability of Actor, Item, or Ground.
 */
public enum Abilities {
    //ACTOR ABILITIES:
    REST,                   //Refills EstusFlask, PlayerHealth
    DRINK,                  //Drink
    DEATH,                  //Player dead
    FALL,                   //Fall into Valley
    LIGHT,                  //Lights bonfire
    TRAVEL,                 //Travels between bonfires
    TRAVEL_FIRE,            //Travel to Firelink Shrine
    TRAVEL_FIER,            //Travel to Fiery Wastes
    TRAVEL_GRAV,            //Travel to The Graves Bonfire
    TRAVEL_LOND,            //Travel to Anor Londor's Bonfire

    //ENEMY ABILITIES:
    FOLLOW,                 //Follow Behaviour
    RANDOM,                 //Dies randomly


    //ITEM ABILITIES:
    REFILL,                 //REFILLS Player health
    HPBOOST,                //Increase Players HP by 25 points

    //GROUND ABILITIES:
    RESET,                  //REFILLS EstusFlask, Player Health, EnemyPos, EnemyHealth, EnemySkills, REMOVES UNDEAD

    //WEAPON ABILITIESC
    CRITICALSTRIKE,         //20% chance to deal double damage
    SPINATTACK,             //Active abilities that hits any enemies in adjacent squares for 25 damage (can be used anytime)
    DULLNESS,               //Hitting enemies not weak will deal 35 damage rather than 70
    CHARGE,                 //Charges Storm Rule or three turns, the player cannot do anything
    WINDSLASH,              //Requires CHARGED, deals 140 damage, has 100% hit chance and stings Yhorm.

    RAGEMODE,               //Increases hit rate by 30%
    BURNGROUND,             //Burns players on dirt for 25 hit points.

    EMBERMODE,              //Heals Aldrich and burns target's ground


    //INTERACTION ABILITIES:
    getVendor,              //Vendor Interaction
    attackEnemy,
}
