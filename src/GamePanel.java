import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font enterFont;
	Font gameOver;
	Timer frameDraw;
	Rocketship rocket;
	
	public GamePanel() {
		
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont  = new Font("Arial", Font.PLAIN, 18);
		gameOver = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000/60,this);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		rocket = new Rocketship(250,700,50,50);
		
	}
	
	@Override
	public void paintComponent(Graphics g){

		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	void updateMenuState() { 
	}
	
	void updateGameState() { 
	}
	 
	void updateEndState()  {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAUGE INVADERS", 15, 100);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 150, 300);
		g.drawString("Press SPACE for instructions", 120, 500);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocket.draw(g);
	}
	
	
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(gameOver);
		g.setColor(Color.BLACK);
		g.drawString("Game Over!", 120, 100);
		g.setFont(enterFont);
		g.drawString("You killed " + " enemies", 155, 300);
		g.drawString("Press ENTER to restart", 140, 500);
	}

	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    if(rocket.y>0) {
			    	rocket.up();
			    }
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				 if(rocket.x<425) {
				    rocket.right();
				 }
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				if(rocket.y<725) {
				    rocket.down();
				 }
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(rocket.x>0) {
				    rocket.left();
				 }
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}





































