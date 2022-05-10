package skb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyBoardInput implements KeyListener, InputStrategy {
	Controller c;
	
	public KeyBoardInput(JFrame frame) {
		frame.addKeyListener(this);
	}
	
	@Override
	public void setController(Controller c) {
		this.c = c;	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	c.move(-1, 0);
	            break;
	        case KeyEvent.VK_DOWN:
	        	c.move(1,  0);
	            break;
	        case KeyEvent.VK_LEFT:
	        	c.move(0, -1);
	            break;
	        case KeyEvent.VK_RIGHT:
	        	c.move(0,  1);
	            break;
	        default:
	        	System.out.println("Invalid");
	     }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
