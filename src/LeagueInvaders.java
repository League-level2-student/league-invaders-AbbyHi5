import javax.swing.JFrame;

public class LeagueInvaders {

	GamePanel game = new GamePanel();
	JFrame frame = new JFrame("League Invaders");
	
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	static LeagueInvaders leauge = new LeagueInvaders();
	
	public static void main(String[] args) {
		
		leauge.setup();
		
	}
	
	void setup() {
		
		frame.addKeyListener(game);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		
	}
	
}
