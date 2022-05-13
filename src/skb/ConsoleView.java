package skb;

public class ConsoleView implements Update {
	private Model model;
	
	public ConsoleView(Model model) {
		this.model = model;
	}
	
	@Override
	public void update() {
		for(int i = 0; i < model.getLevelMapLength(); i++) {
			String row = "[ ";
			for(int j = 0; j < model.getLevelMapRowLength()- 1; j++) {
				row += model.getBlockFromCoord(i, j) + ", ";
			}
			System.out.println(row + model.getBlockFromCoord(i, model.getLevelMapRowLength() - 1) + " ]");
		}
		System.out.print(", " + (model.getTotPoints() - model.getCoveredPoints()) + " more to go.");
		System.out.println();
	}

}
