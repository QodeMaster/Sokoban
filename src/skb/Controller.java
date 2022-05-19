package skb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Controller {
	private Model model;
	private ArrayList<Update> view;
	
	public Controller(Model model) {
		this.model = model;
		this.view = new ArrayList<>();
	}

	void move(int di, int dj) {
		model.move(di, dj, view);
	}

	public void addView(Update view) {
		this.view.add(view);
		
	}
	
}
