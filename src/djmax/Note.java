package djmax;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBlue = new ImageIcon(Note.class.getResource("../images/noteBlue.png")).getImage(); 
	private Image noteYellow = new ImageIcon(Note.class.getResource("../images/noteYellow.png")).getImage(); 
	private int x, y = 540 - (1000 / IntroView.SLEEP_TIME * IntroView.NOTE_SPEED) * IntroView.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	
	
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	public Note(String noteType) {
		if(noteType.equals("S"))
			x = 0;
		else if(noteType.equals("D"))
			x = 120;
		else if(noteType.equals("K"))
			x = 240;
		else if(noteType.equals("L"))
			x = 360;
		
		this.noteType = noteType;
	}
	
	public void drop() {
		y += IntroView.NOTE_SPEED;
		if(y > 560) {
			System.out.println("Miss");
			close();
		}
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteYellow, x, y, null);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(IntroView.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void judge() {
		if(y >= 515) {
			Game.score += 10;
			System.out.println("Good");
			close();
		}
		else if(y >= 525) {
			Game.score += 20;
			System.out.println("Cool");
			close();
		}
		else if(y >= 535) {
			Game.score += 30;
			System.out.println("Great");
			close();
		}
	}
}
