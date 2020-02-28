
public class MazeTile {
	private boolean northIsWall;
	private boolean eastIsWall;
	private boolean southIsWall;
	private boolean westIsWall;

	// To keep track of tile's position in the maze
	// Value will be given during the generation of the maze

	private int xCord;
	private int yCord;

	public MazeTile(int wallNumber) {
		//default x,y
		this.xCord = this.yCord = 0;
		
		northIsWall = false;
		eastIsWall = false;
		southIsWall = false;
		westIsWall = false;
		
		while (wallNumber > 0) {
			// TODO randomly set up appropriate number of walls
		}

	}

	public boolean isNorthIsWall() {
		return northIsWall;
	}

	public void setNorthIsWall(boolean northIsWall) {
		this.northIsWall = northIsWall;
	}

	public boolean isEastIsWall() {
		return eastIsWall;
	}

	public void setEastIsWall(boolean eastIsWall) {
		this.eastIsWall = eastIsWall;
	}

	public boolean isSouthIsWall() {
		return southIsWall;
	}

	public void setSouthIsWall(boolean southIsWall) {
		this.southIsWall = southIsWall;
	}

	public boolean isWestIsWall() {
		return westIsWall;
	}

	public void setWestIsWall(boolean westIsWall) {
		this.westIsWall = westIsWall;
	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}


}
