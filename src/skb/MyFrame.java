package skb;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	Can panel;
	
   public MyFrame(Can p) {
        super("Sokoban");
        panel = p;
        this.setContentPane(panel);
        
        addKeyListener(new Controller(panel));
   }

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
	   
        MyFrame frame = new MyFrame(new Can(adress, playerI, playerJ, level1));
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(32*8 + 96, 32*10 + 96);
        frame.setVisible(true); 
   }
}
