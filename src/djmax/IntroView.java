package djmax;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IntroView extends JFrame {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 3;
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 2;
	
	public static Game game;

	private JPanel contentPane;
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground = new ImageIcon(IntroView.class.getResource("../images/introBackground.jpg")).
			getImage();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroView frame = new IntroView(new MainView(), new GameView());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//실행했을때 첫 화면
	public IntroView(MainView mainPanel, GameView gamePanel) {
		setResizable(false);
		setSize(new Dimension(1280, 720));
		setTitle("리듬게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//첫 화면 음악 자동 실행
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		
		gamePanel.setBounds(0, 0, 1274, 691);
		contentPane.add(gamePanel);
		
		
		
		mainPanel.setBounds(0, 0, 1274, 691);
		contentPane.add(mainPanel);
		
		mainPanel.gameView = gamePanel;
		gamePanel.mainView = mainPanel;
		
		//첫 화면
		JPanel introPanel = new JPanel() {
			public void paint(Graphics g) {
				screenImage = createImage(1274, 691);
				screenGraphic =screenImage.getGraphics();
				screenDraw((Graphics2D) screenGraphic);
				g.drawImage(screenImage, 0, 0, null);
			}
			
			public void screenDraw(Graphics2D g) {
				g.drawImage(introBackground, 0, 0, null);
				paintComponents(g);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.repaint();
			}
		};
		introPanel.setLayout(null);
		introPanel.setBounds(0, 0, 1274, 691);
		contentPane.add(introPanel);
		
		//시작하기 버튼
		JButton startButton = new JButton("");
		ImageIcon startButtonIcon = new ImageIcon(IntroView.class.getResource("../images/start.png"));
		ImageIcon startButtonEnterIcon = new ImageIcon(IntroView.class.getResource("../images/startEnter.png"));
		startButton.setIcon(startButtonIcon);
		startButton.setBounds(95, 321, 250, 80);
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
				introPanel.setVisible(false);
				mainPanel.setVisible(true);
				introMusic.close();
				mainPanel.selectTrack(0);
			}
		});
		introPanel.add(startButton);
		
		//종료하기 버튼
		JButton exitButton = new JButton("");
		ImageIcon exitButtonIcon = new ImageIcon(IntroView.class.getResource("../images/exit.png"));
		ImageIcon exitButtonEnterIcon = new ImageIcon(IntroView.class.getResource("../images/exitEnter.png"));
		exitButton.setIcon(exitButtonIcon);
		exitButton.setBounds(95, 422, 250, 80);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterIcon);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonIcon);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		introPanel.add(exitButton);
	}
	
	
}
