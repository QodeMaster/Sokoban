package skb;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Model {
	
	private ArrayList<Level> lvl_LIST;
	private Level lvl;
	private int i;
	private int j;
	private int levelCounter = -1;
	
	
	public Model(ArrayList<Level> lvl_LIST) {
		this.lvl_LIST = lvl_LIST;
		newLevel();
	}
	
	void newLevel() { // Move to next level
		levelCounter++;
		lvl   = lvl_LIST.get(levelCounter);
		i = lvl.getStartPosI();
		j = lvl.getStartPosJ();
	}
	
	int getLevelMapLength() { return lvl.getLevelLength(); }
	int getLevelMapRowLength() { return lvl.getLevelRowLength(); }
	int getBlockFromCoord(int I, int J) { return lvl.getLevelCoordValue(I, J); }
	int getTotPoints() { return lvl.getTotPoints(); }
	int getCoveredPoints() { return lvl.getCoveredPoints(); }
	
	void move(int di, int dj, ArrayList<Update> view) {
		int iCoord = i + di;
		int jCoord = j + dj;
		
		if(lvl.getLevelCoordValue(iCoord, jCoord) == 0 || lvl.getLevelCoordValue(iCoord, jCoord)== 1) { // Regular Move or if move over marker
    		lvl.updateLevelMapCoord(i, j, lvl.getMarkerCoordValue(i, j)); //level[i][j] = markedPoints[i][j];
    		i += di;
    		j += dj;
    		lvl.updateLevelMapCoord(i, j, 4); //level[i][j] = 4;
    		for(Update v : view) { v.update(); }
    	} else if((lvl.getLevelCoordValue(iCoord, jCoord) == 2 || lvl.getLevelCoordValue(iCoord, jCoord) == 3) 
    			&& (lvl.getLevelCoordValue(iCoord + di, jCoord + dj) == 0 || lvl.getLevelCoordValue(iCoord + di, jCoord + dj) == 1 )) { // Move Box
    		lvl.updateLevelMapCoord(i, j, lvl.getMarkerCoordValue(i, j)); // level[i][j] = markedPoints[i][j];
    		i += di;
    		j += dj;
    		lvl.updateLevelMapCoord(i, j, 4); //level[i][j] = 4;
    		if(lvl.getMarkerCoordValue(i, j) ==  1) lvl.updateCoveredPoints(lvl.getCoveredPoints() - 1); // lvl.coveredPoints--;
    		if(lvl.getMarkerCoordValue(iCoord + di, jCoord + dj) ==  1) {
    			lvl.updateLevelMapCoord(iCoord + di, jCoord + dj, 3); // level[iCoord + di][jCoord + dj] = 3;
    			lvl.updateCoveredPoints(lvl.getCoveredPoints() + 1); // lvl.coveredPoints++;
    		} else lvl.updateLevelMapCoord(iCoord + di, jCoord + dj, 2); // level[iCoord + di][jCoord + dj] = 2;
    		if(lvl.getTotPoints() - lvl.getCoveredPoints() == 0 && levelCounter + 1 != lvl_LIST.size()) { newLevel(); }
    		for(Update v : view) { v.update(); }
    	}
	}
}
