
public class MazeTile {
	private boolean northIsWall;
	private boolean eastIsWall;
	private boolean southIsWall;
	private boolean westIsWall;

	// To keep track of tile's position in the maze
	// Value will be given during the generation of the maze

	public int xCord;
	public int yCord;

	public MazeTile(int wallNumber) {
		//default x,y
		this.xCord = 0;
		this.yCord = 0;
		
		while (wallNumber > 0) {
			// TODO randomly set up appropriate number of walls
		}

	}

	public void setxCord(int x) {
		System.out.println("Inside setxCord");
		this.xCord = x;
	}

	public void setyCord(int y) {
		System.out.println("Inside setyCord");
		this.yCord = y;
	}

}
