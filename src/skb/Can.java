package skb;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Can extends JPanel {
	String[] pics;
	BufferedImage[] imgs = new BufferedImage[6];
	Level lvl;
	int i;
	int j;
	
	public Can(String[] arg, int i, int j, Level level) {
		pics = arg;
		this.i = i;
		this.j = j;
		lvl = level;
		initPics();
	}
	
	public void paintComponent(Graphics g) {
        //g.fillRect(20, 20, 150, 150); // Draw on g here e.g.
    	super.paintComponent(g);
    	drawBoard(g, lvl);
    }
	
	void drawBoard(Graphics g, Level level) {
		for(int k = 0; k < level.level.length; k++) {
			for(int l = 0; l < level.level[0].length; l++) {
				g.drawImage(imgs[level.level[k][l]], 32*l, 32*k, null);
			}
		}
	}
	
	void update() {
		System.out.println(lvl.totPoints - lvl.coveredPoints);
		repaint();
	}
	
	void initPics() {
		for(int k = 0; k < pics.length; k++) {
			imgs[k] = recieveImg(pics[k]);
		}
	}
	
	BufferedImage recieveImg(String adress) {
		try {
		    BufferedImage myPicture = ImageIO.read(new File(adress));
		    return myPicture;
		} catch (Exception e) {
			e.printStackTrace(); 
			return null;
		}
	}
}
