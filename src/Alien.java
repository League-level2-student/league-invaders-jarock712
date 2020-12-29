import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public void update() {
		y+=speed;
		super.update();
	}
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}
	}
	
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 1;
		if (needImage) {
		    loadImage ("alien.png");
		}
		if (ObjectManager.score == 5) {
			level++;
		}
		if (level == 2) {
			speed = 3;
		}
		if (ObjectManager.score == 10) {
			level++;
		}
		if (level == 3) {
			speed = 6;
		}
		if (ObjectManager.score == 15) {
			level++;
		}
		if (level == 4) {
			speed = 9;
		}
		if (ObjectManager.score == 20) {
			level++;
		}
		if (level == 5) {
			speed = 12;
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