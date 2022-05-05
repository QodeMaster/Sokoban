package skb;

public class Level {
	int[][] markedPoints;
	int[][] level;
	int coveredPoints;
	int totPoints;
	
	public Level(int[][] level, int[][] map) {
		this.level		  = level;
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

}
