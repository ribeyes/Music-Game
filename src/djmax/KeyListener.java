package djmax;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(IntroView.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			IntroView.game.press_S();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			IntroView.game.press_D();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			IntroView.game.press_K();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			IntroView.game.press_L();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(IntroView.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			IntroView.game.release_S();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			IntroView.game.release_D();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			IntroView.game.release_K();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			IntroView.game.release_L();
		}
	}
}
