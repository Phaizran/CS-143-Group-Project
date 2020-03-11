
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		
		
		
	}

}
