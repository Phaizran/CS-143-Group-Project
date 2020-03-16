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
	public Rectangle end;
	
	public Player(int width, int height) {
		xPos = (width / 2.0f) - (width * 0.025f);
		yPos = (height / 2.0f) - (height * 0.05f);
		tick = width * 0.005f;
		bounds = new Rectangle((int) (width * 0.249) , (int) (height * 0.29), (int) (width * 0.52), (int) (height * 0.43));
		hitBox = new Rectangle((int) xPos, (int) yPos, (int) (width * 0.05), (int) (height * 0.1));
		
		northDoor = new Rectangle((int) (width * 0.45), (int) (height * 0.2), (int) (width * 0.1) + 1, (int) (height * 0.1));
		southDoor = new Rectangle((int) (width * 0.45), (int) (height * 0.7), (int) (width * 0.1) + 1, (int) (height * 0.1));
		westDoor = new Rectangle((int) (width * 0.2), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
		eastDoor = new Rectangle((int) (width * 0.75), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
		
		end = new Rectangle((int) (width * 0.45), (int) (height * 0.45), (int) (width * 0.05), (int) (height * 0.1) + 1);
		
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
						break;
					}
					case 2 : {
						Main.goSouth();
						xPos = northDoor.x;
						yPos = northDoor.y + northDoor.height;
						break;
					}
					case 3 : {
						Main.goWest();
						xPos = eastDoor.x - hitBox.width;
						yPos = eastDoor.y;
						break;
					}
					case 4 : {
						Main.goEast();
						xPos = westDoor.x + westDoor.width;
						yPos = westDoor.y;
						break;
					}
				}
			}
		}
		hitBox.x = (int) xPos;
		hitBox.y = (int) yPos;
		Main.window.getContentPane().repaint();
		if (Main.map[Main.currentX][Main.currentY].isEnd) {
			if (end.intersects(hitBox)) {
				Main.newMap(Main.mS);
			}
		}
	}
	
	public void drawP(Graphics2D g, int width, int height) {
		g.setColor(Color.CYAN);
		g.fillOval(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
		//test code for bounds
//		g.setColor(Color.RED);
//		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	public boolean isValidMove(float x, float y) {
		if (bounds.contains(x,y) && bounds.contains(x + hitBox.width, y + hitBox.height) ) {
		return true;
		}
		return false;
	}
	
	public int checkDoor(float x, float y) {
		if (!Main.map[Main.currentX][Main.currentY].isNorthWall() && 
				northDoor.intersects(new Rectangle((int) x, (int) y, hitBox.width, hitBox.height))) {
			return 1;
		}
		if (!Main.map[Main.currentX][Main.currentY].isSouthWall() && 
				southDoor.intersects(new Rectangle((int) x, (int) y, hitBox.width, hitBox.height))) {
			return 2;
		}
		if (!Main.map[Main.currentX][Main.currentY].isWestWall() && 
				westDoor.intersects(new Rectangle((int) x, (int) y, hitBox.width, hitBox.height))) {
			return 3;
		}
		if (!Main.map[Main.currentX][Main.currentY].isEastWall() && 
				eastDoor.intersects(new Rectangle((int) x, (int) y, hitBox.width, hitBox.height))) {
			return 4;
		}
		return -1;
	}

}
