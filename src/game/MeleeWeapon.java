package game;

import edu.monash.fit2099.engine.WeaponItem;

public class MeleeWeapon extends WeaponItem {
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */

    int price;
    public MeleeWeapon(String name, char displayChar, int damage, String verb, int hitRate, int price) {
        super(name, displayChar, damage, verb, hitRate);
        this.price = price;
        this.portable = false;
    }

    public int getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }
}
