
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
	private int[][] correctPath;
	//width and height of the maze
	private int width, height;
	
	public MazeSolver(MazeGenerator maze)
	{
		//acquiring the information about the maze and initialize solver
		this.width = map.length;
		this.height = map[0].length;
		this.map = maze.map;
		before = new boolean[width][height];
		correctPath = new int[width][height];   
		this.sX = 0;
		this.sY = 0;
		this.eX = width - 1;
		this.eY = height - 1;
	}
	public boolean solver(int sX, int sY) {
		if(solverHelper(sX, sY))
		{
			return true;
		}
		return false;
	}
	public int[][] getSolver()
	{
		return correctPath;
	}
	
	private boolean solverHelper(int x, int y) {
		//if you are at the end, return true;
		if(x == eX && y == eY)
		{
			return true;
		}
		//checking if we came to this place before or if it's wall
		if(before[x][y])
		{
			return false;
		}
		
		//mark that we came here before
		before[x][y] = true;
		
		//make sure it doesn't go over the wall in y direction
		if(!map[x][y].isEastIsWall())
		{
			//going right
			if(solverHelper(x+1, y))
			{
				correctPath[x][y]= 1;
				return true;
			}
		}
		if(!map[x][y].isSouthIsWall())
		{
			//going down
			if(solverHelper(x, y - 1))
			{
				correctPath[x][y]= 1;
				return true;
			}
		}
		if(!map[x][y].isNorthIsWall())
		{
			//going up
			if(solverHelper(x, y + 1))
			{
				correctPath[x][y]= 1;
				return true;
			}
		}
		//make sure it doesn't go over the wall in x direction
		if(!map[x][y].isWestIsWall())
		{
			//going left
			if(solverHelper(x-1,y))
			{
				correctPath[x][y]= 1;
				return true;
			}
		}
	
		return false;
	}
}
