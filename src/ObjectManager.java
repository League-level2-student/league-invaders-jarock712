import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;

public ObjectManager(Rocketship rocket) {
	this.rocket = rocket;
}
public void addProjectile(Projectile projectiles) {
	
}
Random random = new Random();
public void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
public void update() {
	for (int i = 0; i < aliens.size(); i++) {
		Alien allAliens = aliens.get(i);
		allAliens.update();
		if (allAliens.y > 800) {
			allAliens.isActive(false);
		}
	}
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile allProjectiles = projectiles.get(i);
		allProjectiles.update();
		if (allProjectiles.y > 800) {
			allProjectiles.isActive(false);
		}
	}
}
public void draw(Graphics g) {
	rocket.draw(g);
	for (int i = 0; i < aliens.size(); i++) {
		Alien allAliens = aliens.get(i);
		allAliens.draw(g);
	}
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile allProjectiles = projectiles.get(i);
		allProjectiles.draw(g);
	}
}
public void purgeObjects() {
	for (int i = 0; i < aliens.size(); i++) {
		Alien allAliens = aliens.get(i);
		if (allAliens.isActive == false) {
			aliens.remove(i);
		}
	}
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile allProjectiles = projectiles.get(i);
		if (allProjectiles.isActive == false) {
			projectiles.remove(i);
		}
	}
}
}
