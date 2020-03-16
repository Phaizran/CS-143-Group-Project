
public class MazeTile {
	private boolean northIsWall = false;
	private boolean eastIsWall = false;
	private boolean southIsWall = false;
	private boolean westIsWall = false;
	
	private boolean visitedBefore = false;
	
	public boolean isEnd = false;
	public boolean isStart = false;

	private int xCord = -1;
	private int yCord = -1;

	public MazeTile(int x, int y) {
		//default x,y
		xCord = x;
		yCord = y;
	}

	public boolean isNorthWall() {
		return northIsWall;
	}

	public void setNorthIsWall(boolean northIsWall) {
		this.northIsWall = northIsWall;
	}

	public boolean isEastWall() {
		return eastIsWall;
	}

	public void setEastIsWall(boolean eastIsWall) {
		this.eastIsWall = eastIsWall;
	}

	public boolean isSouthWall() {
		return southIsWall;
	}

	public void setSouthIsWall(boolean southIsWall) {
		this.southIsWall = southIsWall;
	}

	public boolean isWestWall() {
		return westIsWall;
	}

	public void setWestIsWall(boolean westIsWall) {
		this.westIsWall = westIsWall;
	}

	public int getxCord() {
		return xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public boolean isVisitedBefore() {
		return visitedBefore;
	}


	public void setVisitedBefore(boolean visitedBefore) {
		this.visitedBefore = visitedBefore;
	}
	

}
