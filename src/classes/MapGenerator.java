package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class MapGenerator {
	/**
	 * TODO: this will eventually be a class that is called by the main game The
	 * IslanderGame will ask this class for a map
	 * 
	 * @hacked by CrazyMike
	 */
	public static void main(String[] args) {

		MapOfTheGame map = new MapOfTheGame();
		newRandomLocation(map);
		genTreasure(map);
		initialMapStats(map);
		genMap(map);
		map.grip();

	}

	private static void newRandomLocation(MapOfTheGame map) {
		map.setxBound(getNewRandom(10, 20));
		map.setStartingX(getNewRandom(1, 5));
		map.setyBound(getNewRandom(10, 20));
		map.setStartingY(getNewRandom(1, 5));
		map.setCurrentX(map.getStartingX());
		map.setCurrentY(map.getStartingY());

	}

	private static int getNewRandom(int a, int b) {
		Random r = new Random();
		return r.nextInt(a, b);
	}

	private static void genTreasure(MapOfTheGame map) {
		int treasureProportion = (int) ((map.getxBound() * map.getyBound()) * 0.09);  // about 9% of the spaces have treasure
		map.setTotalTresure(treasureProportion);
		map.setoTreasureX(getNewRandom(1, map.getxBound()));
		map.setoTreasureY(getNewRandom(1, map.getyBound()));
		Map<Integer, Integer> treasureXY = new HashMap<>();

		for (int i = 0; i <= map.getTotalTresure(); i++) {
			treasureXY.put(getNewRandom(1, map.getxBound()-1), getNewRandom(1, map.getyBound()-1));
		}
		map.setTreasureXY(treasureXY);
	}

	private static void initialMapStats(MapOfTheGame map) {
		int counter = 1;

		System.out.println("Grid size: " + map.getxBound() + " by " + map.getyBound() + ". ");
		System.out.println("Starting Location: (" + map.getStartingX() + ", " + map.getStartingY() + ").");

		if (map.getoTreasureX() == 0 || map.getoTreasureY() == 0) {
			System.out.println("There is no treasure.");
		} else {
			System.out
					.println("Original Treasure Location: (" + map.getoTreasureX() + ", " + map.getoTreasureY() + ").");
		}

		for (Entry<Integer, Integer> coord : map.getTreasureXY().entrySet()) {
			System.out.println("Treasure " + (counter) + " coord: (" + coord.getKey().toString() 
					+ ", " + coord.getValue().toString() + ").");
			counter++;
		}
	}

	private static void genMap(MapOfTheGame map) {

		if (map.getLifetime() == 0) {
			map.setDirection(getNewRandom(1, 5));
		} // Land is NWES

		for (int j = map.getxBound(); j >= 1; j--) {
			if (j < 10) {
				System.out.print(" " + j);
			} else {
				System.out.print(j);
			} // Row Numbers

			int t = 0;// this is pointless
			for (int i = 1; i <= map.getxBound(); i++) {

				if (i == map.getCurrentX() && j == map.getCurrentY()) {
					System.out.print(" ●");// ◯●
				} else if (i == map.getoTreasureX() && j == map.getoTreasureY()) {
					System.out.print(" T");// ◯●
				} else if (markNewTreasure(i, j, map)) {
					t++;
				} else {
					if (map.getStartingY() < map.getyBound() / 2) {
						map.setDirection(1);
					}
					if (map.getStartingX() > map.getxBound() / 2) {
						map.setDirection(2);
					}
					if (map.getStartingX() < map.getxBound() / 2) {
						map.setDirection(3);
					}
					if (map.getStartingY() > map.getyBound() / 2) {
						map.setDirection(4);
					}

					switch (map.getDirection()) {
						case 1 -> {
							System.out.print( j < map.getStartingY() ? " ~" : " ■" );
						} // Land is North
						case 2 -> {
							System.out.print( i > map.getStartingX() ? " ~" : " ■" );
						} // Land is West
						case 3 -> {
							System.out.print( i < map.getStartingX() ? " ~" : " ■" );
						} // Land is East
						case 4 -> {
							System.out.print( j > map.getStartingY() ? " ~" : " ■" );
						} // Land is South
						default -> System.out.print(" X");// ⬜■
						}// Random land direction
					}
			} // Acii Map Gen
			System.out.print("\n");
		} // Row Numbers, Ascii, and Current

		for (int k = 0; k < map.getxBound() + 1; k++) {
			switch (k) {
			case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> System.out.print(" " + k);
			default -> System.out.print(k);
			}
		} // Column Numbers
	}

	/**
	 * will find if there is a valid treasure location, mark the location and if
	 * found increment "t" value j is y and i is x coords key x and value is y
	 */
	public static boolean markNewTreasure(int i, int j, MapOfTheGame map) { //

		for (Entry<Integer, Integer> entry : map.getTreasureXY().entrySet()) {
			if (entry.getKey() == i && entry.getValue() == j) {
				System.out.print(" 0");// â—¯â—
				return true;
			}

		}
		return false;
	}
	
}