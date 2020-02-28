
public class MazeGenerator {

	public MazeTile[][] map;

	public MazeGenerator(int width, int height) {
		map = new MazeTile[width][height];

		System.out.println("Width: " + map.length + " Height: " + map[0].length);

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y] = new MazeTile(0);
				map[x][y].setxCord(x);
				map[x][y].setyCord(y);
			}

		}

		// Randomly Generating Walls, TODO: MAY NEED TO SET MORE LIMITS, SUCH AS MAX WALLS
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				double north = Math.random();
				double east = Math.random();
				double south = Math.random();
				double west = Math.random();

				// Barrier can Change based on how open or closed in we want maze
				double barrier = 0.5;

				if (north < barrier)
					map[x][y].setNorthIsWall(true);
				if (south < barrier)
					map[x][y].setSouthIsWall(true);
				if (east < barrier)
					map[x][y].setSouthIsWall(true);
				if (west < barrier)
					map[x][y].setWestIsWall(true);

			}
		}

		// Opening Walls When There is an Open Wall Adjacent
		// WARNING: BE CAREFUL OF NONEXISTING TILES
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {

			}
		}

		// Assigning Border Walls

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (x == 0)
					map[x][y].setWestIsWall(true);
				if (x == map.length - 1)
					map[x][y].setEastIsWall(true);
				if (y == 0)
					map[x][y].setNorthIsWall(true);
				if (y == map.length - 1)
					map[x][y].setSouthIsWall(true);
			}
		}
	}

	public void printInfo() {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				System.out.println("Pos: " + map[x][y].getxCord() + "," + map[x][y].getyCord());
				System.out.println("North Wall:" + map[x][y].isNorthIsWall() + " East Wall: " + map[x][y].isEastIsWall()
						+ " South Wall: " + map[x][y].isSouthIsWall() + " West Wall: " + map[x][y].isWestIsWall() + "\n");

			}
		}
	}

}