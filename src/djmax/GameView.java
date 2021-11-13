package djmax;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JPanel {
	JLabel gameBackground;
	private JLabel titleName;
	private JLabel score;
	private String title;	
	
	MainView mainView;

	
	private Image screenImage;
	private Graphics screenGraphic;
	
	//각 키를 눌렀을 때 나오는 이미지 설정을 위한 라벨
	static JLabel key_L = new JLabel("");
	static JLabel key_K = new JLabel("");
	static JLabel key_D = new JLabel("");
	static JLabel key_S = new JLabel("");	
	
	private Image blackboard = new ImageIcon(GameView.class.getResource("../images/blackboard.png")).
			getImage();

	
	
	//게임화면
	public GameView() {
		
		setLayout(null);
		setVisible(false);
		addKeyListener(new KeyListener());
		
		//뒤로가기 버튼
		JButton backButton = new JButton("");
		backButton.setBounds(1171, 31, 60, 60);
		ImageIcon backButtonIcon = new ImageIcon(MainView.class.getResource("../images/backButton.png"));
		ImageIcon backButtonEnterIcon = new ImageIcon(MainView.class.getResource("../images/backButtonEntered.png"));
		backButton.setIcon(backButtonIcon);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnterIcon);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonIcon);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				mainView.setVisible(true);
				mainView.selectTrack(mainView.nowSelected);
				IntroView.game.close();
			}
		});
		add(backButton);
		
		
		
		key_L.setBounds(360, 0, 120, 540);
		add(key_L);
		
		
		key_K.setBounds(240, 0, 120, 540);
		add(key_K);
		
		
		key_D.setBounds(120, 0, 120, 540);
		add(key_D);
		
		
		key_S.setBounds(0, 0, 120, 540);
		add(key_S);
		
		//곡 이름 표시
		titleName = new JLabel("");
		titleName.setFont(new Font("D2Coding", Font.PLAIN, 24));
		titleName.setBounds(12, 577, 241, 36);
		add(titleName);
		
		//노트 판정 점수
		score = new JLabel("점수: ");
		score.setFont(new Font("D2Coding", Font.PLAIN, 24));
		score.setBounds(294, 631, 78, 36);
		add(score);
		
		
		gameBackground = new JLabel("");
		gameBackground.setBounds(480, 0, 794, 691);
		add(gameBackground);
		
		
	}
	
	
	public void paint(Graphics g) {
		screenImage = createImage(1274, 691);
		screenGraphic =screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(blackboard, 0, 0, null);
		g.setFont(new Font("D2Coding", Font.PLAIN, 24));
		g.drawString("" + Game.score, 370, 657);
		IntroView.game.screenDraw(g);
		paintComponents(g);
		this.repaint();
	}
	
	public void setLabelText(String title) {
		titleName.setText("곡 제목: " + title);
	}
}
