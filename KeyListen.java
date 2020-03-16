
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			Main.p.pSetPos(0, -1);
		}
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.p.pSetPos(0, 1);
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.p.pSetPos(-1, 0);
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.p.pSetPos(1, 0);
		}
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

}
