import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	public void update() {
		y-=speed;
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
	
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public void isActive(boolean b) {
		// TODO Auto-generated method stub
		this.isActive = b;
	}
}
