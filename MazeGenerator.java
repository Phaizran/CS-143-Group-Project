
public class MazeGenerator {

	public MazeTile[][] map;

	public int length;
	public int width;
	
	public boolean End;
	public boolean Start;


	public MazeGenerator(int width, int length) {
		map = new MazeTile[length][width];
		this.length = length;
		this.width = width;

		System.out.println("Width: " + this.width + " length: " + length);

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y] = new MazeTile(0);
				map[x][y].setxCord(x);
				map[x][y].setyCord(y);
			}

		}

		map[0][0].isStart = true;
		map[map.length - 1][map[0].length - 1].isEnd = true;

		// Randomly Generating Walls, TODO: MAY NEED TO SET MORE LIMITS, SUCH AS MAX
		// WALLS
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
				if(map[x][y].isEastIsWall() && y+1 < width) {
					map[x][y+1].setWestIsWall(true);
				} else if(map[x][y].isNorthIsWall() && x-1 > -1 ){
					map[x-1][y].setSouthIsWall(true);
				} else if(map[x][y].isSouthIsWall() && x+1 < length) {
					map[x+1][y].setNorthIsWall(true);
				} else if (map[x][y].isWestIsWall() && y-1 > -1) {
					map[x][y-1].setEastIsWall(true);
				}

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
				System.out.print("x" + x + ",y" + y + " ");
			}
			System.out.println();
		}
	}

}