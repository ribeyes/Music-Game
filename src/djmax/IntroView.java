package djmax;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import djmax.Music;

import javax.swing.JButton;

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
		introMusic.start();
		
		JPanel introPanel = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				Image image = new ImageIcon("images/introBackground.jpg").getImage();
				g.drawImage(image, 0, 0, d.width, d.height, null);
			}
		};
		introPanel.setLayout(null);
		introPanel.setBounds(0, 0, 1274, 691);
		contentPane.add(introPanel);
		
		JButton startButton = new JButton("");
		startButton.setIcon(new ImageIcon("images/start.png"));
		startButton.setBounds(95, 321, 250, 80);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		introPanel.add(startButton);
		
		JButton exitButton = new JButton("");
		exitButton.setIcon(new ImageIcon("images/exit.png"));
		exitButton.setBounds(95, 422, 250, 80);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		introPanel.add(exitButton);
	}
}
