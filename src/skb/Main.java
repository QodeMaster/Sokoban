package skb;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main { /* Note to Self: Main ska vara game1, game2 i mobil etc. */
	/* T.ex. main ska inte extend:a frame om spelet endast sker i  konsolen*/
	/* ^ Eftersom Main extend:ar JFrame, ända till 2022-05-06 16:44 ^ */

   public static void main(String args[]) {
	   String[] adress = new String[] { 
        		"C:\\Users\\davazi20\\eclipse-workspace\\skban\\blank.png",
        		"C:\\Users\\davazi20\\eclipse-workspace\\skban\\blankmarked.png", 
        		"C:\\Users\\davazi20\\eclipse-workspace\\skban\\crate.png",
        		"C:\\Users\\davazi20\\eclipse-workspace\\skban\\crateMarked.png",
        		"C:\\Users\\davazi20\\eclipse-workspace\\skban\\player.png",
        		"C:\\Users\\davazi20\\eclipse-workspace\\skban\\wall.png"
        };
	   int[][] lvl1 = new int[][] {
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 5, 5, 0, 0, 0, 5, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 0, 0, 2, 0, 0, 5, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 5, 5, 0, 0, 0, 5, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 1, 5, 5, 0, 0, 5, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 0, 5, 0, 1, 0, 5, 5, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 2, 0, 0, 0, 0, 0, 5, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0},
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	   };
	   int[][] lvl1MarkedSpots = new int[][] {
		   new int[] { 7, 7 },
		   new int[] { 6, 4 }
		   //new int[] { 3, 2 }
	   };
	   int playerI = 4;
	   int playerJ = 4;
	   Level level1 = new Level(lvl1, lvl1MarkedSpots, playerI, playerJ);
	   
	   int[][] lvl2 = new int[][] {
		   	new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		   	new int[] {0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0},
			new int[] {0, 5, 0, 0, 5, 5, 0, 0, 1, 1, 5, 5, 5, 0},
			new int[] {0, 5, 0, 2, 0, 0, 0, 0, 0, 0, 5, 5, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 5, 1, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 5, 5, 5, 5, 5, 0, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 5, 0, 0, 2, 2, 0, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 5, 0},
			new int[] {0, 5, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 5, 0},
			new int[] {0, 5, 0, 0, 0, 5, 5, 1, 0, 0, 0, 0, 5, 0},
			new int[] {0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0},
		   	new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	   };
	   int[][] lvl2MarkedSpots = new int[][] {
		   new int[] { lvl2.length - 3, 7},
		   new int[] { 4, lvl2[0].length - 3},
		   new int[] { 2, 8 },
		   new int[] { 2, 9 }
	   };
	   Level level2 = new Level(lvl2, lvl2MarkedSpots, playerI, playerJ);
	   
	   ArrayList<Level> lvl_LIST = new ArrayList<Level>();
	   lvl_LIST.add(level1);
	   lvl_LIST.add(level2);
	   
	   Model model = new Model(adress, lvl_LIST);
	   
	   SwingView swingView     = new SwingView(model);
	   ConsoleView consoleView = new ConsoleView(model);
	   

       Controller controller   = new Controller(model);
	   controller.addView(swingView);
	   controller.addView(consoleView);
	   
	   JFrame frame = new JFrame("Sokoban");
	   
	   InputStrategy keyBoard = new KeyBoardInput(frame);
	   keyBoard.setController(controller);
        
        frame.setContentPane(swingView);
        //frame.addKeyListener(controller);
        
        
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(model.level[0].length * 32 + 32, model.level.length * 32 + 64);
        frame.setVisible(true); 
   }
}
