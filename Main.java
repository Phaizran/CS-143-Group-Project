import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static int currentX = 0;
	public static int currentY = 0;
	public final static int MAZE_SIZE = 10;
	public static MazeTile[][] map;
	public static Color brown = new Color(0.40f, 0.22f, 0.0f);
	private static boolean mazeCreated = false;
	public static Player p;
	public static KeyListen kL = new KeyListen();
//	public static Room currentRoom;

	public static void main(String[] args) {
		JFrame window;

		
		window = new JFrame("A-Maze-Zing");
		window.setLocationByPlatform(true);
		@SuppressWarnings("serial")
		final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics gx) {
				Graphics2D g = (Graphics2D) gx;
				int width = getWidth();
				int height = getHeight();
				g.clearRect(0, 0, width, height);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setBackground(Color.BLACK);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

				this.repaint(100);
				draw(g, width, height);
			}
		};


		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int wWidth = (int) (d.width * 0.8);
		int wHeight = (int) (d.height * 0.8);
		window.setSize(wWidth, wHeight);
		window.setBackground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		window.setContentPane(panel);
		window.setVisible(true);
		window.setResizable(false);
		panel.addKeyListener(kL);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		map = new MazeGenerator(MAZE_SIZE, MAZE_SIZE).map;
		MazeSolver mS = new MazeSolver(map, MAZE_SIZE, MAZE_SIZE);
		p = new Player(panel.getWidth(), panel.getHeight());
		newMap(mS);		

	}
	
	public static void draw(Graphics2D g, int width, int height) {
		if (!mazeCreated) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.WHITE);
			g.drawString("LOADING ...", width / 2, height / 2);
		}else {
			// Drawing baseline room needed regardless of wall/door status
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.DARK_GRAY);
			g.fillRect((int) (width * 0.2), (int) (height * 0.2), (int) (width * 0.6), (int) (height * 0.6));
			g.setColor(Color.GRAY);
			g.fillRect((int) (width * 0.2), (int) (height * 0.2), (int) (width * 0.25), (int) (height * 0.1));
			g.fillRect((int) (width * 0.55), (int) (height * 0.2), (int) (width * 0.25), (int) (height * 0.1));
			g.fillRect((int) (width * 0.2), (int) (height * 0.7), (int) (width * 0.25), (int) (height * 0.1));
			g.fillRect((int) (width * 0.55), (int) (height * 0.7), (int) (width * 0.25), (int) (height * 0.1));
			g.fillRect((int) (width * 0.2), (int) (height * 0.3), (int) (width * 0.05), (int) (height * 0.15));
			g.fillRect((int) (width * 0.2), (int) (height * 0.55), (int) (width * 0.05), (int) (height * 0.15));
			g.fillRect((int) (width * 0.75), (int) (height * 0.3), (int) (width * 0.05), (int) (height * 0.15));
			g.fillRect((int) (width * 0.75), (int) (height * 0.55), (int) (width * 0.05), (int) (height * 0.15));
			
			//if north side is a wall fill in wall if north side is a door and hasen't been entered yet draw closed door 
			if (map[currentX][currentY].isNorthWall()) {
				g.setColor(Color.GRAY);
				g.fillRect((int) (width * 0.45), (int) (height * 0.2), (int) (width * 0.1) + 1, (int) (height * 0.1));
			}else if (currentY - 1 > -1 && !map[currentX][currentY - 1].isVisitedBefore()){
				g.setColor(brown);
				g.fillRect((int) (width * 0.45), (int) (height * 0.2), (int) (width * 0.1) + 1, (int) (height * 0.1));
			}
			
			//if south side is a wall fill in wall if south side is a door and hasen't been entered yet draw closed door 
			if (map[currentX][currentY].isSouthWall()) {
				g.setColor(Color.GRAY);
				g.fillRect((int) (width * 0.45), (int) (height * 0.7), (int) (width * 0.1) + 1, (int) (height * 0.1));
			}else if (currentY + 1 < MAZE_SIZE && !map[currentX][currentY + 1].isVisitedBefore()){
				g.setColor(brown);
				g.fillRect((int) (width * 0.45), (int) (height * 0.7), (int) (width * 0.1) + 1, (int) (height * 0.1));
			}
			
			//if west side is a wall fill in wall if west side is a door and hasen't been entered yet draw closed door 
			if (map[currentX][currentY].isWestWall()) {
				g.setColor(Color.GRAY);
				g.fillRect((int) (width * 0.2), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
			}else if (currentX - 1 < -1 && !map[currentX - 1][currentY].isVisitedBefore()){
				g.setColor(brown);
				g.fillRect((int) (width * 0.2), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
			}
			
			//if east side is a wall fill in wall if east side is a door and hasen't been entered yet draw closed door 
			if (map[currentX][currentY].isEastWall()) {
				g.setColor(Color.GRAY);
				g.fillRect((int) (width * 0.75), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
			}else if (currentX + 1 < MAZE_SIZE && !map[currentX + 1][currentY].isVisitedBefore()){
				g.setColor(brown);
				g.fillRect((int) (width * 0.75), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
			}
			
			if(map[currentX][currentY].isEnd) {
				g.setColor(Color.PINK);
				g.fillRect((int) (width * 0.45), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
			}
			
			p.drawP(g, width, height);
		}	
	}
	
	public static void newMap(MazeSolver mS) {
		mazeCreated = false;
		currentX = 0;
		currentY = 0;
		 
		while (!mS.solver(0, 0)) {
			map = new MazeGenerator(MAZE_SIZE, MAZE_SIZE).map;
			mS = new MazeSolver(map, MAZE_SIZE, MAZE_SIZE);
		}
		
		for (int x = 0; x < MAZE_SIZE; x++) {
			for (int y = 0; y < MAZE_SIZE; y++) {
				map[x][y].setVisitedBefore(false);
			}
		}
		map[currentX][currentY].setVisitedBefore(true);
		mazeCreated = true;
	}

	public static void goNorth() {
		currentY--;
	}

	public static void goSouth() {
		currentY++;
		
	}

	public static void goWest() {
		currentX--;
	}

	public static void goEast() {
		currentX++;
	}
}