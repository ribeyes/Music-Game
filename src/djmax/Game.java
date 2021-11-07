package djmax;

import javax.swing.ImageIcon;

public class Game extends Thread{
	GameView gameView;
	private ImageIcon keyboardIcon = new ImageIcon(Game.class.getResource("../images/keyboard.png")); 
	
    public void press_S() {
    	gameView.key_S.setIcon(keyboardIcon); 
	}

    public void release_S() {
    	gameView.key_S.setIcon(null);
	}

    public void press_D() {
    	gameView.key_D.setIcon(keyboardIcon); 
	}

    public void release_D() {
    	gameView.key_D.setIcon(null);
	}

    public void press_K() {
    	gameView.key_K.setIcon(keyboardIcon); 
	}

    public void release_K() {
    	gameView.key_K.setIcon(null);
	}

    public void press_L() {
    	gameView.key_L.setIcon(keyboardIcon); 
	}

    public void release_L() {
    	gameView.key_L.setIcon(null);
	}

    
    
	@Override
	public void run() {
		
	}
	
	
}
