import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font titleFont2 = new Font("Arial", Font.PLAIN, 16);
    Font font1 = new Font("Quicksand", Font.BOLD, 24);
    Timer frameDraw;
    Timer alienSpawn;
    Rocketship rocket = new Rocketship(225, 650, 50, 50);
    ObjectManager manager = new ObjectManager(rocket);
    public GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
    public void updateMenuState() {
    	
    }
    public void updateGameState() {
    	rocket.update();
    	manager.update();
    	if (rocket.isActive == false) {
			currentState = END;
		}
    }
    public void updateEndState() {
    	
    }
    
    public void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("League Invaders", 60, 100);
    	g.setFont(titleFont2);
    	g.drawString("Press ENTER to start!", 150, 350);
    	g.setFont(titleFont2);
    	g.drawString("Press ESC for instructions.", 135, 450);
    }
    public void drawGameState(Graphics g) {
    	if (needImage) {
		    loadImage ("space.png");
		}
    	g.drawImage(image, 0, 0, null);
    	manager.draw(g);
    	manager.getScore();
    	g.setColor(Color.GREEN);
    	g.setFont(font1);
    	g.drawString("Score: " + manager.getScore(), 15, 35);
    	g.setColor(Color.GREEN);
    	g.setFont(font1);
    	g.drawString("Level: " + GameObject.getLevel(), 375, 35);
    }
    public void drawEndState(Graphics g) {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.BLACK);
    	g.drawString("GAME OVER", 100, 100);
    	g.setFont(titleFont2);
    	g.setColor(Color.BLACK);
    	g.drawString("You scored: " + "", 100, 300);
    	g.setFont(titleFont2);
    	g.setColor(Color.BLACK);
    	g.drawString("Press ENTER to restart!", 100, 350);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	boolean moves = true;
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			startGame();
		    if (currentState == END) {
		        currentState = MENU;
		        alienSpawn.stop();
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			manager.addProjectile(rocket.getProjectile());
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_UP){
			rocket.up = true;
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_DOWN){
		    rocket.down = true;
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_LEFT){
		    rocket.left = true;
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_RIGHT){
		    rocket.right = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (moves == true && e.getKeyCode()==KeyEvent.VK_UP){
			rocket.up = false;
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_DOWN){
		    rocket.down = false;
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_LEFT){
		    rocket.left = false;
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_RIGHT){
		    rocket.right = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	public void startGame() {
		alienSpawn = new Timer(1000 , manager);
	    alienSpawn.start();
	}
}