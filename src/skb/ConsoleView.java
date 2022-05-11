package skb;

public class ConsoleView implements Update {
	Model model;
	int[][] lvl;
	
	public ConsoleView(Model model) {
		this.model = model;
	}
	
	@Override
	public void update() {
		lvl = model.lvl.level;
		for(int i = 0; i < lvl.length; i++) {
			String row = "[ ";
			for(int j = 0; j < lvl[0].length - 1; j++) {
				row += lvl[i][j] + ", ";
			}
			System.out.println(row + lvl[i][lvl[i].length - 2] + " ]");
		}
		System.out.print(", " + (model.getLevel().totPoints - model.getLevel().coveredPoints) + " more to go.");
		System.out.println();
	}

}
