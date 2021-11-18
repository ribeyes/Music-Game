package djmax;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	GameView gameView;
	private ImageIcon keyboardIcon = new ImageIcon(Game.class.getResource("../images/keyboard.png")); 
	
	private String titleName;
	private String musicTitle; 
	private Music gameMusic; 
	
	static int score = 0;
	
	ArrayList<Note> noteList = new ArrayList<>(); 
	
	public Game(String titleName, String musicTitle) {
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	
	
	public void screenDraw(Graphics2D g) {
		
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i); //떨어지는 노트에 키를 눌러서 노트를 없앰.
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
	}
	
	/*
	 * Beat 클래스의 각 노트에 대한 시작시간과 키 위치 정보를 받아서   
	 * Note 클래스에서 실시간으로 노트를 게임화면에 나타나게 하는 역할을 한다.
	 */
	public void dropNotes() {
		Beat[] beats = null;
		if(titleName.equals("Firefly")) {
			int startTime = 4460 - IntroView.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "K"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "K"),
					new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 12, "L"),
					new Beat(startTime + gap * 14, "D")
			};
		}
		else if(titleName.equals("Higher")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "K")
			};
		}
		else if(titleName.equals("Colors")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "K")
			};
		}
		int i = 0;
		gameMusic.start(); 
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void run() {
		dropNotes();
	}
	
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
	
	public String getTitleName() {
		return titleName;
	}
	
    public void press_S() {
    	judge("S");
    	GameView.key_S.setIcon(keyboardIcon); 
	}

    public void release_S() {
    	GameView.key_S.setIcon(null);
	}

    public void press_D() {
    	judge("D");
    	GameView.key_D.setIcon(keyboardIcon); 
	}

    public void release_D() {
    	GameView.key_D.setIcon(null);
	}

    public void press_K() {
    	judge("K");
    	GameView.key_K.setIcon(keyboardIcon); 
	}

    public void release_K() {
    	GameView.key_K.setIcon(null);
	}

    public void press_L() {
    	judge("L");
    	GameView.key_L.setIcon(keyboardIcon); 
	}

    public void release_L() {
    	GameView.key_L.setIcon(null);
	}

    
    //음악 정지
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	
	
	
}
