import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	public static int level = 1;
	boolean isActive = true;
	Rectangle collisionBox = new Rectangle();
public GameObject(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.collisionBox = new Rectangle(x, y, width, height);
}
public void update() {
	collisionBox.setBounds(x, y, width, height);
}
public static int getLevel() {
	int speed = 0;
	if (speed == 6) {
		level++;
	}
	if (speed == 9) {
		level++;
	}
	if (speed == 12) {
		level++;
	}
	return level;
}
}