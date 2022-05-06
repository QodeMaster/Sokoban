package skb;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Model {
	String[] pics; /* Detta ska vara i model */
	BufferedImage[] imgs = new BufferedImage[6];
	Level lvl;
	int[][] level;
	int[][] markedPoints;
	int i;
	int j;
	
	
	public Model(String[] arg, int i, int j, Level level) {
		pics = arg;
		this.i = i;
		this.j = j;
		lvl = level;
		initAttributes();
	}
	
	void initAttributes() {
		level = lvl.level;
		markedPoints = lvl.markedPoints;
	}
	
	Level getLevel() { return lvl; }
	
	String getUnprocessed(int index) { return pics[index]; }
	
	BufferedImage getImg(int index) { return imgs[index]; }
	void setImg (int index, BufferedImage imageTile) { imgs[index] = imageTile; }
	
	void update(View view) {
		System.out.println(lvl.totPoints - lvl.coveredPoints);
		if(view instanceof JPanel) {
			view.repaint();
		}
	}
	
	void move(int di, int dj, View view) {
		int iCoord = i + di;
		int jCoord = j + dj;
		
		if(level[iCoord][jCoord] == 0 || level[iCoord][jCoord] == 1) { // Regular Move or if move over marker
    		level[i][j] = markedPoints[i][j];
    		i += di;
    		j += dj;
    		level[i][j] = 4;
    		update(view);
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
    		update(view);
    	}
	}
}
