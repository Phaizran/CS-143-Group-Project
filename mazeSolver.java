
public class MazeSolver {
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
	private int width, length;
	//number indicates wall
	private boolean wall;
	
	public MazeSolver(MazeGenerator map)
	{
		//acquiring the information about the maze and initialize solver
		this.width = map.width;
		this.length = map.length;
		this.map = map.map;
		before = new boolean[width][length];
		correctPath = new boolean[width][length];   
		this.sX = 0;
		this.sY = 0;
		this.eX = length;
		this.eY = width;
	}
	public boolean[][] getBefore() {
		return before;
	}
	public boolean[][] getCorrectPath() {
		return correctPath;
	}
	public boolean solver() {
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
		//checking if we came to this place before or it is the wall
		if(before[x][y])
		{
			return false;
		}
		before[x][y] = true;
		
		//make sure it doesn't go over the wall in y direction
		if(y > 0)
		{
			//going down
			if(solverHelper(x, y - 1))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		if(y < length - 1)
		{
			//going up
			if(solverHelper(x, y + 1))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		//make sure it doesn't go over the wall in x direction
		if(x > 0)
		{
			//going left
			if(solverHelper(x-1,y))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		if(x < width - 1)
		{
			//going right
			if(solverHelper(x+1, y))
			{
				correctPath[x][y]= true;
				return true;
			}
		}
		return false;
	}
}


