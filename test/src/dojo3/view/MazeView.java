package dojo3.view;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dojo3.PlayerGrid;
import dojo3.model.MazeModel;

/**
 * @author Martin
 *
 */
public class MazeView extends PlayerGrid implements Observer {
	
	private MazeModel model;
	
	/**
	 * 
	 */
	public MazeView(MazeModel model, KeyListener controller, int windowWidth, int windowHeight) {
		
		super(model.getObstacles().length, model.getObstacles()[0].length, 780, 500);
		
		this.model = model;
		
		placeObstacles();
		
		placePlayer();
		
		placeMazeExit();
		
		addKeyListener(controller);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	/**
	 * 
	 */
	private void placeObstacles() {
		
		// Go through every tile on the grid
		for ( int i = 0; i < squares.length; i++ ) {
			
			for ( int j = 0; j < squares[i].length; j++ ) {
				
				// With 30% probability, fill it with an obstacle
				if ( model.getObstacles()[i][j] == true ) {
					
					// Fill this square with black to represent an obstacle
					squares[i][j] = Color.BLACK;
					
				}
				
			}
		}
		
	}

	/**
	 * 
	 */
	private void placePlayer() {
		
		/* Once a suitable X and Y position has been chosen for the player, 
		  fill the selected square with red to represent the player  */
		fillSquare(model.getPlayerY(), model.getPlayerX(), Color.RED);
		
	}
	
	/**
	 * 
	 */
	private void placeMazeExit() {
		
		// Randomly select tile for maze exit, and colour it green
		fillSquare(model.getExitY(), model.getExitX(), Color.GREEN);
		
	}
	
	private void clearPlayerSquare() {
		
		// Clear the square, initially.
		fillSquare(model.getPlayerY(), model.getPlayerX(), null);
				
	}

	@Override
	public void update(Observable o, Object arg) {
		
		// If the next square contains a green tile, game complete
		if ( model.checkDone() ) {
			
			JOptionPane.showMessageDialog(this, "Game complete!");
			
		}
		
		if ( arg != null && ((String)arg).equals("remove") ) {
			
			clearPlayerSquare();
			
		} else {
			
			/* And paint a new square for the player (note that this may be the same square if the
			 * player has not moved).
			 */
			placePlayer();
			
		}
		
	}

}
