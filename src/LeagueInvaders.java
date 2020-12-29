import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LeagueInvaders {
	JFrame invaderFrame = new JFrame();
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	GamePanel gamePanel = new GamePanel();
	public void setup() {
		invaderFrame.add(gamePanel);
		invaderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		invaderFrame.setVisible(true);
		invaderFrame.setSize(WIDTH, HEIGHT);
		invaderFrame.addKeyListener(gamePanel);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				LeagueInvaders invade = new LeagueInvaders();
				invade.setup();
			}
		});
	}
}
