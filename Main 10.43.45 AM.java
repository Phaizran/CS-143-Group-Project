
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

<<<<<<< HEAD
		MazeGenerator map = new MazeGenerator(10,10);
		MazeSolver solver = new MazeSolver(map);
		
		map.printInfo();
		
		System.out.println(solver.solver());
		boolean[][] solve = solver.getCorrectPath();
		boolean[][] places = solver.getBefore();
		for(int i = 0; i < map.length; i++)
		{
			for(int a = 0; a < map.width; a++)
			{
				System.out.print(solve[i][a] + ", ");
			}
			System.out.println();
		}

		
		
		
=======
		MazeGenerator maze = new MazeGenerator(10,10);
		maze.printInfo();
		MazeSolver solve = new MazeSolver("pass in the parameter");
>>>>>>> 94ba6cf918e885c848445f9bdf3ec8bf2cffc06c
	}

}
