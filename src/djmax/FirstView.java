package djmax;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class FirstView extends JFrame {

		public static final int SCREEN_WIDTH = 1280;
		public static final int SCREEN_HEIGHT = 720;
		private JPanel introView;
		private Image screenImage;
		private Graphics screenGraphic;
		
		private Image introBackground = new ImageIcon("images/introBackground.jpg").getImage();
		
		private ImageIcon startButtonImage = new ImageIcon(new ImageIcon("images/startButton.png").getImage().
				getScaledInstance(180, 250, Image.SCALE_SMOOTH));
		private ImageIcon exitButtonImage = new ImageIcon(new ImageIcon("images/exitButton.png").getImage().
				getScaledInstance(180, 250, Image.SCALE_SMOOTH));
		
		
		private JButton startButton = new JButton(startButtonImage);
		private JButton exitButton = new JButton(exitButtonImage);
		
		
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView frame = new FirstView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		
		public FirstView() {
		setUndecorated(true); // 메뉴바 없애기
		setResizable(false);
		setTitle("리듬게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		introView = new JPanel();
		introView.setBorder(new EmptyBorder(5, 5, 5, 5));
		introView.setLayout(null);
		setContentPane(introView);
		setBackground(new Color(0, 0, 0, 0));
		
		startButton.setBounds(150, 400, 150, 50);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 시작 이벤트
			}
		});
		getContentPane().add(startButton);
		
		exitButton.setBounds(150, 500, 150, 50);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(exitButton);
		
		Music introMusic = new Music("introMusic.mp3", true);
		//introMusic.start(); //음악 실행
	}
	
	
	public void paint(Graphics g) {
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
		
	}
}
