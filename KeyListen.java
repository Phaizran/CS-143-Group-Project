import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_W || e.getKeyCode() == e.VK_UP) {
			Main.p.pSetPos(0, -1);
			System.out.println("key is working");
		}
		if (e.getKeyCode() == e.VK_S || e.getKeyCode() == e.VK_DOWN) {
			Main.p.pSetPos(0, 1);
		}
		if (e.getKeyCode() == e.VK_A || e.getKeyCode() == e.VK_LEFT) {
			Main.p.pSetPos(-1, 0);
		}
		if (e.getKeyCode() == e.VK_D || e.getKeyCode() == e.VK_RIGHT) {
			Main.p.pSetPos(1, 0);
		}
	}

}
