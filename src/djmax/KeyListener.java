package djmax;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(GameView.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(GameView.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			
		}
	}
}
