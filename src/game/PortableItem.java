package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */

public class PortableItem extends Item {

	//VARIABLES:

	int price;

	public PortableItem(String name, char displayChar, int price) {
		super(name, displayChar, true);
	}
}
