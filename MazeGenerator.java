
public class MazeGenerator {

	public MazeTile[][] map;

	public int height;
	public int width;
	
	public boolean End;
	public boolean Start;


	public MazeGenerator(int width, int height) {
		map = new MazeTile[width][height];
		this.height = height;
		this.width = width;

//		System.out.println("Width: " + this.width + " length: " + length);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				map[x][y] = new MazeTile(x, y);
			}

		}

		map[0][0].isStart = true;
		map[width - 1][height - 1].isEnd = true;

		// Randomly Generating Walls, TODO: MAY NEED TO SET MORE LIMITS, SUCH AS MAX
		// WALLS
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
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
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (x - 1 > -1 && map[x][y].isWestWall()) {
					map[x - 1][y].setEastIsWall(true);
				}
				if (x + 1 < width && map[x][y].isEastWall()) {
					map[x + 1][y].setWestIsWall(true);
				}
				if (y - 1 > -1 && map[x][y].isNorthWall()) {
					map[x][y - 1].setSouthIsWall(true);
				}
				if (y + 1 < height && map[x][y].isSouthWall()) {
					map[x][y + 1].setNorthIsWall(true);
				}
			}
		}

		// Assigning Border Walls

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (x == 0)
					map[x][y].setWestIsWall(true);
				if (x == width - 1)
					map[x][y].setEastIsWall(true);
				if (y == 0)
					map[x][y].setNorthIsWall(true);
				if (y == height - 1)
					map[x][y].setSouthIsWall(true);
			}
		}
	}

//	public void printInfo() {
//		for (int x = 0; x < map.length; x++) {
//			for (int y = 0; y < map[x].length; y++) {
//				System.out.println("Pos: " + map[x][y].getxCord() + "," + map[x][y].getyCord());
//				System.out.println("North Wall:" + map[x][y].isNorthIsWall() + " East Wall: " + map[x][y].isEastIsWall()
//						+ " South Wall: " + map[x][y].isSouthIsWall() + " West Wall: " + map[x][y].isWestIsWall()
//						+ "\n");
//
//			}
//		}
//	}

}