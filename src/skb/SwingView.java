package skb;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SwingView extends JPanel implements Update{
	private Model model;
	private String[] pics;
	private BufferedImage[] imgs = new BufferedImage[6];
	
	public SwingView(Model model, String[] arg) {
		// Old constructor View(String[] arg, int i, int j, Level level)
		this.model = model;
		pics = arg;
		initPics();
	}
	
	public void paintComponent(Graphics g) {
        //g.fillRect(20, 20, 150, 150); // Draw on g here e.g.
    	super.paintComponent(g);
    	drawBoard(g);
    }
	
	void drawBoard(Graphics g) {
		for(int k = 0; k < model.getLevelMapLength(); k++) {
			for(int l = 0; l < model.getLevelMapRowLength(); l++) {
				g.drawImage(imgs[model.getBlockFromCoord(k, l)], 32*l, 32*k, null);
			}
		}
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
