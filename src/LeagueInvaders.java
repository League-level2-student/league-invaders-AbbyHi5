import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {

	JFrame frame = new JFrame("League Invaders");
	//JPanel panel = new JPanel();
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	static LeagueInvaders leauge = new LeagueInvaders();
	
	public static void main(String[] args) {
		
		leauge.setup();
		
	}
	
	void setup() {
		frame.add(game);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		
	}
	
}
