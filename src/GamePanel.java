import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font titleFont2 = new Font("Arial", Font.PLAIN, 16);
    Timer frameDraw;
    Rocketship rocket = new Rocketship(225, 650, 25, 25); 
    public GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    
	}
    public void updateMenuState() {
    	
    }
    public void updateGameState() {
    	
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
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	rocket.draw(g);
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
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_UP && rocket.x < 500){
			rocket.up();
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_DOWN && rocket.x > 5){
		    rocket.down();
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_LEFT && rocket.y > 1){
		    rocket.left();
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_RIGHT && rocket.x < 500){
		    rocket.right();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}