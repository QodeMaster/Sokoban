package skb;

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
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		   new int[] {0, 0, 0, 5, 5, 5, 5, 5, 0, 0},
		   new int[] {0, 5, 5, 5, 0, 0, 0, 5, 0, 0},
		   new int[] {0, 5, 0, 0, 2, 0, 0, 5, 0, 0},
		   new int[] {0, 5, 5, 5, 0, 0, 0, 5, 0, 0},
		   new int[] {0, 5, 1, 5, 5, 0, 0, 5, 0, 0},
		   new int[] {0, 5, 0, 5, 0, 1, 0, 5, 5, 0},
		   new int[] {0, 5, 2, 0, 0, 0, 0, 0, 5, 0},
		   new int[] {0, 5, 0, 0, 0, 0, 0, 0, 5, 0},
		   new int[] {0, 5, 5, 5, 5, 5, 5, 5, 5, 0},
		   new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	   };
	   int[][] lvl1MarkedSpots = new int[][] {
		   new int[] { 6, 5 },
		   new int[] { 5, 2 }
		   //new int[] { 3, 2 }
	   };
	   int playerI = 3;
	   int playerJ = 3;
	   lvl1[playerI][playerJ] = 4;
	   Level level1 = new Level(lvl1, lvl1MarkedSpots);
	   
	   int[][] lvl2 = new int[][] {
	    new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	    new int[] {0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 0, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 0, 0, 0, 0, 5, 2, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 0, 0, 5, 5, 5, 0, 0, 2, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 0, 0, 5, 0, 0, 2, 0, 0, 2, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 5, 5, 5, 0, 5, 0, 5, 5, 5, 0, 5, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 0},
		new int[] {0, 5, 0, 0, 0, 5, 0, 5, 5, 5, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 1, 5, 0},
		new int[] {0, 5, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 0},
		new int[] {0, 5, 5, 5, 5, 5, 0, 5, 5, 5, 5, 0, 5, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0, 5, 0},
		new int[] {0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 5, 5, 5, 0, 0, 5, 5, 5, 5, 5, 5, 5, 0},
		new int[] {0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	   };
	   int[][] lvl2MarkedSpots = new int[][] {
		   new int[] { lvl2.length - 5, lvl2[0].length - 3},
		   new int[] { lvl2.length - 6, lvl2[0].length - 3}
		   //new int[] { 3, 2 }
	   };
	   /*playerI = lvl2.length - 4;
	   playerJ = 13;
	   lvl2[playerI][playerJ] = 4;
	   Level level2 = new Level(lvl2, lvl2MarkedSpots);*/
	   
	   Model model = new Model(adress, playerI, playerJ, level1);
	   View view   = new View(model);
	   Controller controller  = new Controller(model, view); 
	   
        JFrame frame = new JFrame("Sokoban");
	   //Main frame = new Main(new View(adress, playerI, playerJ, level2));
        
        frame.setContentPane(view);
        frame.addKeyListener(controller);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(model.level[0].length * 32 + 32, model.level.length * 32 + 64);
        frame.setVisible(true); 
   }
}
