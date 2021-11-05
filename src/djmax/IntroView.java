package djmax;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
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
	
	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroView frame = new IntroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IntroView() {
		setResizable(false);
		setSize(new Dimension(1280, 720));
		setTitle("리듬 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Music introMusic = new Music("introMusic.mp3", true);
		//introMusic.start();
		
		JPanel introPanel = new JPanel() {
			
			public void paintComponent(Graphics g) {
				ImageIcon image = new ImageIcon(IntroView.class.getResource("../images/introBackground.jpg"));
				g.drawImage(image.getImage(), 0, 0, null);
			}
		};
		introPanel.setLayout(null);
		introPanel.setBounds(0, 0, 1274, 691);
		contentPane.add(introPanel);
		
		
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
				
			}
		});
		introPanel.add(startButton);
		
		
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
