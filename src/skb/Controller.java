package skb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	Model model;
	View view;
	Level lvl;
	int[][] level;
	int[][] markedPoints;
	int i;
	int j;
	
	public Controller(Model model, View view) {
		this.view  = view;
		this.model = model;
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
	        	model.move(-1, 0, view);
	            break;
	        case KeyEvent.VK_DOWN:
	        	model.move(1, 0, view);
	            break;
	        case KeyEvent.VK_LEFT:
	        	model.move(0, -1, view);
	            break;
	        case KeyEvent.VK_RIGHT:
	        	model.move(0, 1, view);
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
