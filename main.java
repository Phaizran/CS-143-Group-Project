
public class main {

	public static void main(String[] args) {
		MazeGenerator maze = new MazeGenerator(3,9);
		MazeSolver mazeSolve = new MazeSolver(maze);
		System.out.println(mazeSolve.solver());
		System.out.println(mazeSolve.getSolver());
		int[][] solved = mazeSolve.getSolver();
		
		for(int i = 0; i < solved.length; i++) {
			for(int z = 0; z < solved[i].length; z++) {
				System.out.print(solved[i][z]);
			}
			System.out.println();
		}
		
	}
	
}

