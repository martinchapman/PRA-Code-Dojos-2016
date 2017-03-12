package dojo3;

import dojo3.controller.MazeListener;
import dojo3.model.MazeModel;
import dojo3.view.MazeView;

public class Main {

	public static void main(String[] args) {
		
		MazeModel model = new MazeModel(30, 25);
		
		MazeListener controller = new MazeListener(model);
		
		MazeView view = new MazeView(model, controller, 780, 500);
		
		model.addObserver(view);
		
	}

}
