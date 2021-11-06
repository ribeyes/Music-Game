package djmax;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GameView extends JPanel {
	JLabel gameBackground;
	MainView mainView;
	static Game game = new Game();
	
	
	public GameView() {
		setLayout(null);
		setVisible(false);
		
		addKeyListener(new KeyListener());
		
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
			}
		});
		add(backButton);
		
		gameBackground = new JLabel("");
		gameBackground.setBounds(0, 0, 1274, 691);
		add(gameBackground);
	}
}
