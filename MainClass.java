import java.util.Scanner;

public class MainClass {
	private static int condition = 0;
	private static String input;

	public static void main(String[] args) throws Exception {
		MazeGenerator maze = new MazeGenerator(9, 9);
		MazeSolver mazeSolve = null;
		if (condition == 0) {
			System.out.println("Please enter if you want to make the maze easier or hard, e for easy and h for hard");
			Scanner scan = new Scanner(System.in);
			input = scan.next();
		}
		if (input.contains("e")) {
			if (condition == 0) {
				System.out.println("Easy route, Have fun!");
			}
			condition++;
			mazeSolve = new MazeSolver(maze);
			while (mazeSolve.solver() == false) {
				main(args);
			}
		} else if (input.contains("h")) {
			if (condition == 0) {
				System.out.println("You have choosen the hardest map. good luck!");
			}
			condition++;
			mazeSolve = new MazeSolver(maze, 1);
			while (mazeSolve.solver() == false) {
				main(args);
			}
		} else {
			System.out.println("Invalid Input, System can not be terminated");
			System.out.println("please retry");
			main(args);
		}

		int[][] solved = mazeSolve.getSolver();
		System.exit(10);
	}

}
