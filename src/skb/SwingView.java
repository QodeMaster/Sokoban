package skb;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SwingView extends JPanel implements Update{
	Model model;
	
	public SwingView(Model model) {
		// Old constructor View(String[] arg, int i, int j, Level level)
		this.model = model;
		initPics();
	}
	
	public void paintComponent(Graphics g) {
        //g.fillRect(20, 20, 150, 150); // Draw on g here e.g.
    	super.paintComponent(g);
    	drawBoard(g, model.getLevel());
    }
	
	void drawBoard(Graphics g, Level level) {
		for(int k = 0; k < level.level.length; k++) {
			for(int l = 0; l < level.level[0].length; l++) {
				g.drawImage(model.getImg(level.level[k][l]), 32*l, 32*k, null);
			}
		}
	}
	
	void initPics() {
		for(int k = 0; k < model.pics.length; k++) {
			model.setImg(k, recieveImg(model.getUnprocessed(k)));
		}
	}
	
	BufferedImage recieveImg(String adress) {
		try {
		    BufferedImage myPicture = ImageIO.read(new File(adress));
		    return myPicture;
		} catch (Exception e) {
			System.out.println("Img Error!!!");
			e.printStackTrace(); 
			return null;
		}
	}

	@Override
	public void update() {
		this.repaint();
	}
}
