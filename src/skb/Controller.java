package skb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Controller implements KeyListener {
	Model model;
	ArrayList<Update> view;
	Level lvl;
	
	public Controller(Model model) {
		this.model = model;
		this.view = new ArrayList<>();
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


	public void addView(Update view) {
		this.view.add(view);
		
	}
	
}
