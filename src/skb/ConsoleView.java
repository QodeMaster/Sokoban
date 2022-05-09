package skb;

public class ConsoleView implements Update {
	Model model;
	int[][] lvl;
	
	public ConsoleView(Model model) {
		this.model = model;
		this.lvl = model.lvl.level;
	}
	
	@Override
	public void update() {
		for(int i = 0; i < lvl.length; i++) {
			String row = "[ ";
			for(int j = 0; j < lvl[0].length - 1; j++) {
				row += lvl[i][j] + ", ";
			}
			System.out.println(row + lvl[i][lvl[i].length - 2] + " ]");
		}
		System.out.println();
	}

}
