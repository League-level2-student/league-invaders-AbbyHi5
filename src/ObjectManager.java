import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;
	Random random;
	Rocketship r;
	int score;

	public ObjectManager(Rocketship r) {

		random = new Random();
		aliens = new ArrayList<Alien>();
		projectiles = new ArrayList<Projectile>();
		this.r = r;
		score = 0;

	}

	public int getScore() {
		return this.score;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update(){
		for (int i = 0; i < aliens.size(); i++) {
					
					aliens.get(i).update();
					
					if(aliens.get(i).y >= LeagueInvaders.HEIGHT) {
						
						aliens.get(i).isActive = false;
					
					}
						
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			
			projectiles.get(i).update();
		}
		
		r.update();
		checkCollision();
		prugeObjects();
		
	}
	

	void draw(Graphics g) {

		r.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void prugeObjects() {

		for (int i = aliens.size() - 1; i >= 0; i--) {

			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}

		}

		for (int i = projectiles.size() - 1; i >= 0; i--) {

			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}

		}

	}

	public void actionPerformed(ActionEvent arg0) {

		addAlien();
		//System.out.println("Alien");
	}

	void checkCollision() {

		for (int i = 0; i < aliens.size(); i++) {

			for (int j = 0; j < projectiles.size(); j++) {

				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {

					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
					score++;
					
					}

				}

			
			if (r.collisionBox.intersects(aliens.get(i).collisionBox)) {

				aliens.get(i).isActive = false;
				r.isActive = false;
				
			}

		}

	}

}
