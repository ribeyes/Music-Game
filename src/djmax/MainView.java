package djmax;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainView extends JPanel {

	GameView gameView;
	
	ArrayList<Track> trackList = new ArrayList<>();
	
	private ImageIcon gameBackground;
	private ImageIcon titleImage;
	private ImageIcon selectedImage;
	private Music selectedMusic;
	int nowSelected = 0;
	private JLabel musicTitle;
	private JLabel selectedLabel;
	

	
	
	
	public MainView() {
		setLayout(null);
		setVisible(false);
		
		trackList.add(new Track("Firefly Title.png", "Firefly Selected.png", "Firefly Game.jpg", 
				"Firefly Selected.mp3", "Firefly Game.mp3"));
		trackList.add(new Track("Higher Title.png", "Higher Selected.png", "Higher Game.jpg", 
				"Higher Selected.mp3", "Higher Game.mp3"));
		trackList.add(new Track("Colors Title.png", "Colors Selected.png", "Colors Game.jpg", 
				"Colors Selected.mp3", "Colors Game.mp3"));
		
		selectedLabel = new JLabel("");
		selectedImage = new ImageIcon(MainView.class.getResource("/images/Firefly Selected.png"));
		selectedLabel.setBounds(340, 100, 600, 450);
		add(selectedLabel);
		
		musicTitle = new JLabel("");
		musicTitle.setBounds(361, 560, 600, 120);
		add(musicTitle);
		
		JButton startButton = new JButton("");
		ImageIcon startButtonIcon = new ImageIcon(MainView.class.getResource("../images/start.png"));
		ImageIcon startButtonEnterIcon = new ImageIcon(MainView.class.getResource("../images/startEnter.png"));
		startButton.setIcon(startButtonIcon);
		startButton.setBounds(1000, 560, 250, 80);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnterIcon);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonIcon);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected);
			}
		});
		add(startButton);
		
		JButton leftButton = new JButton("");
		ImageIcon leftButtonIcon = new ImageIcon(MainView.class.getResource("/images/leftButton.png"));
		ImageIcon leftButtonEnterIcon = new ImageIcon(MainView.class.getResource("/images/leftButtonEntered.png"));
		leftButton.setIcon(leftButtonIcon);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnterIcon);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonIcon);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftButton);
		
		JButton rightButton = new JButton("");
		ImageIcon rightButtonIcon = new ImageIcon(MainView.class.getResource("/images/rightButton.png"));
		ImageIcon rightButtonEnterIcon = new ImageIcon(MainView.class.getResource("/images/rightButtonEntered.png"));
		rightButton.setIcon(rightButtonIcon);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnterIcon);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonIcon);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(rightButton);
		
		JLabel mainBackground = new JLabel("");
		mainBackground.setIcon(new ImageIcon(MainView.class.getResource("/images/mainBackground.gif")));
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Track.class.getResource("/images/" + trackList.get(nowSelected).getTitleImage()));
		selectedImage = new ImageIcon(Track.class.getResource("/images/" + trackList.get(nowSelected).getStartImage()));
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		musicTitle.setIcon(titleImage);
		selectedLabel.setIcon(selectedImage);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		setVisible(false);
		gameView.setVisible(true);
		gameBackground = new ImageIcon(MainView.class.getResource("/images/" + trackList.get(nowSelected).getGameImage()));
		gameView.gameBackground.setIcon(gameBackground);
		gameView.setFocusable(true); // 이거 넣어야 키 입력했을때 반응함. 생성자에 넣으면 반응 안 함..
		gameView.requestFocus(); // 이거 넣어야 키 입력했을때 반응함. 생성자에 넣으면 반응 안 함..
	}
}
