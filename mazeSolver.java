
public class MazeSolver{
	
	//start points
	private int sX, sY;
	//end points
	private int eX, eY;
	//the map of the maze
	private MazeTile[][] map;
	//the array tracking the path
	private boolean[][] before;
	//the array tracking the correct path;
	private boolean[][] correctPath;
	//width and height of the maze
	private int width, height;
	//number indicates wall
	private int wall;
	
	public MazeSolver(MazeGenerator maze)
	{
		//acquiring the information about the maze and initialize solver
		this.width = map.length;
		this.height = map[0].length;
		this.map = map;
		before = new boolean[width][height];
		correctPath = new boolean[width][height];   
		this.sX = 0;
		this.sY = 0;
		this.eX = width;
		this.eY = height;
	}
	public boolean solver(int sX, int sY) {
		if(solverHelper(sX, sY))
		{
			return true;
		}
		return false;
	}
	
	private boolean solverHelper(int x, int y) {
		//if you are at the end, return true;
		if(x == eX && y == eY)
		{
			return true;
		}
		//checking if we came to this place before or if it's wall
		if(map[x][y].isNorthIsWall()  || map[x][y].isSouthIsWall() || map[x][y].isWestIsWall() || map[x][y].isEastIsWall() || before[x][y])
		{
			return false;
		}
		
		//mark that we came here before
		before[x][y] = true;
		
		//make sure it doesn't go over the wall in y direction
		if(x != width - 1)
		{
			//going right
			if(solverHelper(x+1, y))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		if(y != 0)
		{
			//going down
			if(solverHelper(x, y - 1))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		if(y != height - 1)
		{
			//going up
			if(solverHelper(x, y + 1))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		//make sure it doesn't go over the wall in x direction
		if(x != 0)
		{
			//going left
			if(solverHelper(x-1,y))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
	
		return false;
	}
}
