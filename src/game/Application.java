package game;

import java.util.Arrays;

import java.util.List;

import edu.monash.fit2099.engine.*;
import game.enemies.AldrichDevourer;
import game.enemies.LordOfCinder;
import game.enemies.Skeleton;
import game.terrains.*;

/**
 * The main class for the Design O'Souls game.
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());
		//PROFANE CAPITAL MAP AND FEATURES
		FancyGroundFactory ProfaneCapital = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Valley(),
				new Cemetery());

		List<String> ProfaneCapitalMap = Arrays.asList(
				"..++++++..+++...........................++++......+++.................+++.......",
				"........+++++..............................+++++++.................+++++........",
				"...........+++.......................................................+++++......",
				".......................................................c................++......",
				"......c..................................................................+++....",
				"............................+.................................c...........+++...",
				".............................+++.......++++.....................................",
				".............................++.......+......................++++...............",
				".............................................................+++++++............",
				"..................................###___###...................+++...............",
				"....................c.............#_______#......................+++............",
				"...........++.....................#_______#....................c..+.............",
				".........+++......................#_______#..............c.........++...........",
				"............+++...................####_####..........................+..........",
				"..............+......................................................++.........",
				"..............++.................................................++++++.........",
				"............+++...................................................++++..........",
				"+..................................................................++........c..",
				"++...+++.........................................................++++...........",
				"+++......................................+++................c.......+.++........",
				"++++.......++++.........................++.........................+....++......",
				"#####___#####++++.....c................+...............................+..+.....",
				"_..._....._._#.++......................+...................................+....",
				"...+.__..+...#+++...........................................................+...",
				"...+.....+._.#.+.....+++++...++............c.................................++.",
				"___.......___#.++++++++++++++.+++.............................................++");
		GameMap gameMap = new GameMap(ProfaneCapital, ProfaneCapitalMap);
		world.addGameMap(gameMap);

		//Adds player to map
		Actor player = new Player("Unkindled (Player)", '@', 100);
		world.addPlayer(player, gameMap.at(38, 12));

		// Place Yhorm the Giant/boss in the map
		gameMap.at(6, 25).addActor(new LordOfCinder("Yhorm the Giant"));

		//Adding features to PROFANE CAPITAL
		//Adds Bonfires area to map
		Bonfire bonfireFL = new Bonfire("The Firelink Shrine", gameMap.at(38,11), 101);
		gameMap.at(38,11).setGround(bonfireFL);

		Bonfire bonfireFW = new Bonfire("The Fiery Wastes", gameMap.at(73,25), 102);
		gameMap.at(73, 25).setGround(bonfireFW);

		//Placing Skeletons in the map
		gameMap.at(30,4).addActor(new Skeleton("Skeleton"));
		gameMap.at(40,17).addActor(new Skeleton("Skeleton"));
		gameMap.at(70,23).addActor(new Skeleton("Skeleton"));
		gameMap.at(22,12).addActor(new Skeleton("Skeleton"));
		gameMap.at(42,21).addActor(new Skeleton("Skeleton"));
		gameMap.at(73,14).addActor(new Skeleton("Skeleton"));
		gameMap.at(60,10).addActor(new Skeleton("Skeleton"));
		gameMap.at(15,8).addActor(new Skeleton("Skeleton"));

		//Place Vendor on the map
		gameMap.at(37,11).addActor(new Vendor("Fire Keeper", 'F', 50));

		//Add misc items to map
		gameMap.at(7, 25).addItem(new MeleeWeapon("Storm Ruler", '7', 70, "cuts", 60, 2000));

		//ANOR LANDO MAP AND FEATURES
		FancyGroundFactory AnorLando = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Valley(), new Cemetery());
		List<String> AnorLandoMap = Arrays.asList( //x: 60, y: 12
				"................................c...........................",
				".....c......................................................",
				".........................................................c..",
				"............c...............................c...............",
				"............................................................",
				"............................................................",
				".....###___###.........................c....................",
				".....#_______#.............................++#######___#####",
				".....#_______#..............................#_..._....._._..",
				".....#_______#..............................#....+.__..+....",
				".....####_####..............................#...............",
				".......................................c....#___.......___..");
		GameMap gameMap2 = new GameMap(AnorLando, AnorLandoMap);
		world.addGameMap(gameMap2);

		//Adding Fog Door to first map
		FogDoor fogDoor = new FogDoor(gameMap2.at(59, 0));
		gameMap.at(59, 25).setGround(fogDoor);

		//Adding Fog Door to second map --> added here to access gameMap2 instance
		FogDoor fogDoor2 = new FogDoor(gameMap.at(59, 25));
		gameMap2.at(59, 0).setGround(fogDoor2);

		//Adds Bonfires to second map
		Bonfire bonfireAL = new Bonfire("AnorLondo's Bonfire", gameMap2.at(55,1), 103);
		gameMap2.at(55,1).setGround(bonfireAL);

		Bonfire bonfireTG = new Bonfire("The Graves", gameMap2.at(3,11), 104);
		gameMap2.at(3, 11).setGround(bonfireTG);

		//Adding Chest with legs to second map
		Chest chest = new Chest();
		gameMap2.at(22, 2).setGround(chest);

		//Adding boney bois (Skeleton) to the second map --Ting :333
		gameMap2.at(25,6).addActor(new Skeleton("Skeleton"));
		gameMap2.at(16,10).addActor(new Skeleton("Skeleton"));
		gameMap2.at(43,7).addActor(new Skeleton("Skeleton"));
		gameMap2.at(39,3).addActor(new Skeleton("Skeleton"));

		// Place Aldrich the Devourer boss in the map
		gameMap2.at(50, 10).addActor(new AldrichDevourer("Aldrich The Devourer"));

		//Runs game
		world.run();

	}
}
