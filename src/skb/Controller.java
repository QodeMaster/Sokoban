package skb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	Can panel;
	Level lvl;
	int[][] level;
	int[][] markedPoints;
	int i;
	int j;
	
	public Controller(Can canvas) {
		this.panel = canvas;
		initAttributes();
	}
	
	void initAttributes() {
		lvl   = panel.lvl;
		level = lvl.level;
		markedPoints = lvl.markedPoints;
		i = panel.i;
		j = panel.j;
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
	        	move(-1, 0);
	            break;
	        case KeyEvent.VK_DOWN:
	        	move(1, 0);
	            break;
	        case KeyEvent.VK_LEFT:
	        	move(0, -1);
	            break;
	        case KeyEvent.VK_RIGHT:
	        	move(0, 1);
	            break;
	        default:
	        	System.out.println("Invalid");
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * GENERALIZE ALL MOVABLE DIRECTIONS TO MOVE 
	 * AND COMPLETE CORRECT IMPLEMENTAION OF ICOORD & JCOORD.
	 * */
	
	void move(int di, int dj) {
		int iCoord = i + di;
		int jCoord = j + dj;
		
		if(level[iCoord][jCoord] == 0 || level[iCoord][jCoord] == 1) { // Regular Move
    		level[i][j] = markedPoints[i][j];
    		i += di;
    		j += dj;
    		level[i][j] = 4;
    		panel.update();
    	} else if((level[iCoord][jCoord] == 2 || level[iCoord][jCoord] == 3) 
    			&& (level[iCoord + di][jCoord + dj] == 0 || level[iCoord + di][jCoord + dj] == 1 )) { // Move Box
    		
    		level[i][j]     = markedPoints[i][j];
    		i += di;
    		j += dj;
    		level[i][j]   = 4;
    		if(markedPoints[i][j] ==  1) lvl.coveredPoints--;
    		if(markedPoints[iCoord + di][jCoord + dj] ==  1) {
    			level[iCoord + di][jCoord + dj] = 3;
    			lvl.coveredPoints++;
    		} else level[iCoord + di][jCoord + dj] = 2;
    		panel.update();
    	}
	}
	
}
