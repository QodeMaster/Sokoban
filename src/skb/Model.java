package skb;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Model {
	String[] pics; /* Detta ska vara i model */
	BufferedImage[] imgs = new BufferedImage[6];
	ArrayList<Level> lvl_LIST;
	Level lvl;
	int[][] level;
	int[][] markedPoints;
	int i;
	int j;
	int levelCounter = -1;
	
	
	public Model(String[] arg, ArrayList<Level> lvl_LIST) {
		this.lvl_LIST = lvl_LIST;
		pics = arg;
		newLevel();
	}
	
	void newLevel() { // Move to next level
		levelCounter++;
		lvl   = lvl_LIST.get(levelCounter);
		level = lvl.level;
		markedPoints = lvl.markedPoints;
		i = lvl.i;
		j = lvl.j;
	}
	
	Level getLevel() { return lvl; }
	
	String getUnprocessed(int index) { return pics[index]; }
	
	BufferedImage getImg(int index) { return imgs[index]; }
	void setImg (int index, BufferedImage imageTile) { imgs[index] = imageTile; }
	
	/*void update(View view) {
		System.out.println(lvl.totPoints - lvl.coveredPoints);
		view.repaint();
	}*/
	
	void move(int di, int dj, ArrayList<Update> view) {
		int iCoord = i + di;
		int jCoord = j + dj;
		
		if(level[iCoord][jCoord] == 0 || level[iCoord][jCoord] == 1) { // Regular Move or if move over marker
    		level[i][j] = markedPoints[i][j];
    		i += di;
    		j += dj;
    		level[i][j] = 4;
    		for(Update v : view) { v.update(); }
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
    		if(lvl.totPoints - lvl.coveredPoints == 0 && levelCounter + 1 != lvl_LIST.size()) { newLevel(); }
    		for(Update v : view) { v.update(); }
    	}
	}
	
	/*
	void save() {
	
	}
	
	void load() {
	
	}
	 * */
}
