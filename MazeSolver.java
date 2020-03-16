
public class MazeSolver{
	
	//end points
	private int eX, eY;
	//the map of the maze
	private MazeTile[][] map;
	//width and height of the maze
	private int width, height;
	
	public MazeSolver(MazeTile[][] maze, int width, int height)
	{
		//acquiring the information about the maze and initialize solver
		this.map = maze;
		this.width = width;
		this.height = height;  
		this.eX = width - 1;
		this.eY = height - 1;
	}
	
	public boolean solver(int sX, int sY) {
		return solverHelper(sX, sY);
	}

	private boolean solverHelper(int x, int y) {
		if (x >= width || y >= height || x < 0 || y < 0) {
			return false;
		}
		//if you are at the end, return true;
		if(x == eX && y == eY)
		{
			return true;
		}
		//checking if we came to this place before or if it's wall
		if(map[x][y].isVisitedBefore())
		{
			return false;
		}
		
		//mark that we came here before
		map[x][y].setVisitedBefore(true);
		
		//make sure it doesn't go over the wall in y direction
		if(!map[x][y].isEastWall())
		{
			//going right
			if (solverHelper(x + 1, y)) {
				return true;
			}
		}
		if(!map[x][y].isSouthWall())
		{
			//going down
			if (solverHelper(x, y + 1)) {
				return true;
			}
		}
		if(!map[x][y].isNorthWall())
		{
			//going up
			if (solverHelper(x, y - 1)) {
				return true;
			}
		}
		//make sure it doesn't go over the wall in x direction
		if(!map[x][y].isWestWall())
		{
			//going left
			if (solverHelper(x-1,y)) {
				return true;
			}
		}
	
		return false;
	}
}
