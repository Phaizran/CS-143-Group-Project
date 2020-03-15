
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
	private int[][] correctPath;
	//width and height of the maze
	private int width, height;
	private int p = 1;
	  // define the range 
    private int max,min,range,min2,max2,range2;
	
  
	public MazeSolver(MazeGenerator maze)
	{
		//acquiring the information about the maze and initialize solver
		//generatr random starting point and ending point
		max = maze.length;
		min = 1;
		max2 = maze.width;
		min2 = 1;
		range = max - min;
		range2 = max2 - min2;
		sX = (int)(Math.random() * range) + 1;
		sY = (int)(Math.random() * range2) + 1;
		eX = (int)(Math.random() * range) + 1;
		eY = (int)(Math.random() * range2) + 1;
		this.width = maze.width;
		this.height = maze.length;
		this.map = maze.map;
		before = new boolean[height][width];
		correctPath = new int[height][width];   
	}public MazeSolver(MazeGenerator maze, int a)
	{
		//acquiring the information about the maze and initialize solver
		//harder version
		sX = 1;
		sY = 1;
		eX = maze.length - 2;
		eY = maze.width - 2;
		this.width = maze.width;
		this.height = maze.length;
		this.map = maze.map;
		before = new boolean[height][width];
		correctPath = new int[height][width];   
	}
	public int getSX()
	{
		return sX;
	}
	public int getSY()
	{
		return sY;
	}
	public int getEX()
	{
		return eX;
	}
	public int getEY()
	{
		return eY;
	}
	public boolean[][] getBefore()
	{
		return before;
	}
	public boolean solver() {
		if(solverHelper(sX, sY))
		{
			return true;
		}
		return false;
	}
	public int[][] getSolver()
	{
		for(int i = 0; i < height; i++)
		{
			for(int a = 0; a < width; a++)
			{
				System.out.print(correctPath[i][a] +" ,");
			}
			System.out.println();
		}
		return correctPath;
	}
	
	private boolean solverHelper(int x, int y) {
		//if you are at the end, return true;
		if(y == eY && x == eX)
		{
			correctPath[x][y] = p;
			p++;
			return true;
		}
		//checking if we came to this place before or if it's wall
		if(before[x][y] == true)
		{
			return false;
		}
		
		//mark that we came here before
		before[x][y] = true;
		
		//make sure it doesn't go over the wall in y direction
		if(!map[x][y].isEastIsWall() && y + 1 < width)
		{
			//going right
			if(solverHelper(x, y+1))
			{
				correctPath[x][y]= p;
				p++;
				return true;
			}
		}
		if(!map[x][y].isSouthIsWall() && x + 1 < height)
		{
			//going down
			if(solverHelper(x+1,y))
			{
				correctPath[x][y]= p;
				p++;
				return true;
			}
		}
		if(!map[x][y].isNorthIsWall() && x - 1 > -1)
		{
			//going up
			if(solverHelper(x-1,y))
			{
				correctPath[x][y]= p;
				p++;
				return true;
			}
		}
		//make sure it doesn't go over the wall in x direction
		if(!map[x][y].isWestIsWall() && y - 1 > -1)
		{
			//going left
			if(solverHelper(x,y-1))
			{
				correctPath[x][y]= p;
				p++;
				return true;
			}
		}
	
		return false;
	}
}
