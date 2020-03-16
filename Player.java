import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
	private Rectangle hitBox;
	private Rectangle bounds;
	private float tick, xPos, yPos = 0.0f;
	private Rectangle northDoor;
	private Rectangle southDoor;
	private Rectangle westDoor;
	private Rectangle eastDoor;
	
	public Player(int width, int height) {
		xPos = (width / 2.0f) - (width * 0.025f);
		yPos = (height / 2.0f) - (height * 0.05f);
		tick = width * 0.005f;
		bounds = new Rectangle((int) (width * 0.252) , (int) (height * 0.305), (int) (width * 0.505), (int) (height * 0.405));
		hitBox = new Rectangle((int) xPos, (int) yPos, (int) (width * 0.05), (int) (height * 0.1));
		
		northDoor = new Rectangle((int) (width * 0.45), (int) (height * 0.2), (int) (width * 0.1) + 1, (int) (height * 0.1));
		southDoor = new Rectangle((int) (width * 0.45), (int) (height * 0.7), (int) (width * 0.1) + 1, (int) (height * 0.1));
		westDoor = new Rectangle((int) (width * 0.2), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
		eastDoor = new Rectangle((int) (width * 0.75), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
		
	}
	
	public void pSetPos(int x, int y) {
		if (isValidMove(xPos + (x * tick), yPos + (y * tick))) {
			xPos += (x * tick);
			yPos += (y * tick);
		}else {
			int n = checkDoor(xPos + (x * tick), yPos + (y * tick));
			if (n != -1 && n > 0 && n < 5) {
				switch(n) {
					case 1 : { 
						Main.goNorth();
						xPos = southDoor.x;
						yPos = southDoor.y - hitBox.height;
					}
					case 2 : {
						Main.goSouth();
						xPos = northDoor.x;
						yPos = northDoor.y + hitBox.height;
					}
					case 3 : {
						Main.goWest();
						xPos = eastDoor.x - hitBox.width;
						yPos = eastDoor.y;
					}
					case 4 : {
						Main.goEast();
						xPos = westDoor.x + hitBox.width;
						yPos = westDoor.y;
					}
				}
			}
		}
		hitBox.x = (int) xPos;
		hitBox.y = (int) yPos;
	}
	
	public void drawP(Graphics2D g, int width, int height) {
		g.setColor(Color.CYAN);
		g.fillOval(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
		//test code for bounds
//		g.setColor(Color.RED);
//		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	public boolean isValidMove(float x, float y) {
		if (x > bounds.x && x < bounds.width && y > bounds.y && y < bounds.height) {
			return true;
		}
		return false;
	}
	
	public int checkDoor(float x, float y) {
		if (!Main.map[Main.currentX][Main.currentY].isNorthWall() && northDoor.contains(x, y)) {
			return 1;
		}
		if (!Main.map[Main.currentX][Main.currentY].isSouthWall() && southDoor.contains(x, y)) {
			return 2;
		}
		if (!Main.map[Main.currentX][Main.currentY].isWestWall() && westDoor.contains(x, y)) {
			return 3;
		}
		if (!Main.map[Main.currentX][Main.currentY].isEastWall() && eastDoor.contains(x, y)) {
			return 4;
		}
		return -1;
	}

}
