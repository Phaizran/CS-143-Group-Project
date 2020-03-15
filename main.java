
public class main {

	public static void main(String[] args) {
		MazeGenerator maze = new MazeGenerator(9,9);
		MazeSolver mazeSolve = new MazeSolver(maze);
		
		while(mazeSolve.solver() == false)
		{
			main(args);
		}
		int[][] solved = mazeSolve.getSolver();
		System.exit(10);
	}
	
}

