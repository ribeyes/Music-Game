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
	
	ArrayList<Track> trackList = new ArrayList<>(); // 음악 담기
	
	private ImageIcon gameBackground;
	private ImageIcon titleImage;
	private ImageIcon selectedImage;
	private Music selectedMusic;
	int nowSelected = 0;
	private JLabel musicTitle;
	private JLabel selectedLabel;
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image mainBackground = new ImageIcon(IntroView.class.getResource("../images/mainBackground.gif")).
			getImage();
	
	//음악 선택 화면
	public MainView() {
		//음악 3곡에 대한 정보
		trackList.add(new Track("Firefly Title.png", "Firefly Selected.png", "Firefly Game.jpg", 
				"Firefly Selected.mp3", "Firefly Game.mp3", "Firefly"));
		trackList.add(new Track("Higher Title.png", "Higher Selected.png", "Higher Game.jpg", 
				"Higher Selected.mp3", "Higher Game.mp3", "Higher"));
		trackList.add(new Track("Colors Title.png", "Colors Selected.png", "Colors Game.jpg", 
				"Colors Selected.mp3", "Colors Game.mp3", "Colors"));
		
		setLayout(null);
		setVisible(false);
		
		//곡 선택 이미지
		selectedLabel = new JLabel("");
		selectedImage = new ImageIcon(MainView.class.getResource("/images/Firefly Selected.png"));
		selectedLabel.setBounds(340, 100, 600, 450);
		add(selectedLabel);
		
		musicTitle = new JLabel("");
		musicTitle.setBounds(361, 560, 600, 120);
		add(musicTitle);
		
		//시작하기 버튼
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
				Game.score = 0;
				gameStart(nowSelected);
			}
		});
		add(startButton);
		
		//곡 선택 왼쪽 버튼
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
		
		//곡 선택 오른쪽 버튼
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
	

	public void paint(Graphics g) {
		screenImage = createImage(1274, 691);
		screenGraphic =screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(mainBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	
	//곡 선택 관련 메소드들
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
	
	//시작하기 버튼 눌러서 게임시작하는 메소드
	public void gameStart(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		setVisible(false);
		gameBackground = new ImageIcon(MainView.class.getResource("/images/" + trackList.get(nowSelected).getGameImage()));
		Image changeImg = gameBackground.getImage().getScaledInstance(794, 691, Image.SCALE_SMOOTH);
		ImageIcon changeSizeImage = new ImageIcon(changeImg);
		gameView.gameBackground.setIcon(changeSizeImage); 
		IntroView.game = new Game(trackList.get(nowSelected).getTitleName(), trackList.get(nowSelected).getGameMusic());
		IntroView.game.start();
		gameView.setLabelText(trackList.get(nowSelected).getTitleName());
		gameView.setVisible(true);
		gameView.setFocusable(true); // 이거 넣어야 키 입력했을때 반응함. 생성자에 넣으면 반응 안 함..
		gameView.requestFocus(); // 이거 넣어야 키 입력했을때 반응함. 생성자에 넣으면 반응 안 함..
	}
}
