
public class MazeGenerator {

	public MazeTile[][] map;

	public MazeGenerator(int width, int height) {
		map = new MazeTile[width][height];

		System.out.println("Width: " + map.length + " Height: " + map[0].length);
		
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				System.out.println(x + " " + y);
				
			}

		}
		
	}

	public void print() {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				System.out.println(map[x][y].xCord + "," + map[x][y].yCord + " ");
				
			}
		}
	}
}
