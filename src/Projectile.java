import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public void update() {
		y-=speed;
		super.update();
	}
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, 25, 25, null);
		}
	}
	
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 15;
		if (needImage) {
		    loadImage ("bullet.png");
		}
	}
	public void isActive(boolean b) {
		// TODO Auto-generated method stub
		this.isActive = b;
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
