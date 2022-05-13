package skb;

public class Level {
	private int[][] markedPoints;
	private int[][] level;
	private int coveredPoints;
	private int totPoints;
	private int i;
	private int j;
	
	public Level(int[][] level, int[][] map, int startPosI, int startPosJ) {
		this.level		  = level;
		i = startPosI;
		j = startPosJ;
		this.level[i][j] = 4;
		this.markedPoints = new int[level.length][level[0].length];
		coveredPoints     = 0;
		totPoints         = map.length;
		markerSetter(map);
	}
	
	void markerSetter(int[][] map) {
		for(int[] coord : map) {
			this.markedPoints[coord[0]][coord[1]] = 1;
		}
	}
	
	int getLevelLength() { return level.length; }
	int getLevelRowLength() { return level[0].length; }
	int getLevelCoordValue(int I, int J) { return level[I][J]; }
	int getMarkerCoordValue(int I, int J) { return markedPoints[I][J]; }
	int getTotPoints() { return totPoints; }
	int getCoveredPoints() { return coveredPoints; }
	int getStartPosI() { return i; }
	int getStartPosJ() { return j; }
	
	void updateLevelMapCoord(int I, int J, int value) { level[I][J] = value; }
	void updateMarkerMapCoord(int I, int J, int value) { markedPoints[I][J] = value; }
	void updateCoveredPoints(int value) { coveredPoints = value; }

}
