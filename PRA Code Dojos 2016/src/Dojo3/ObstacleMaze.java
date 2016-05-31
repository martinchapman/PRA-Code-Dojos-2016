package Dojo3;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Martin
 *
 */
public class ObstacleMaze extends PlayerGrid implements KeyListener {

	/**
	 * Keeping the compiler happy...
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public int playerY;
	
	/**
	 * 
	 */
	public int playerX;
	
	/**
	 * 
	 */
	public ObstacleMaze() {
		
		super(30, 25, 780, 500);
		
		placeObstacles();
		
		placeMazeExit();
		
		placePlayer();
		
		addKeyListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * 
	 */
	private void placeObstacles() {
		
		// Go through every tile on the grid
		for ( int i = 0; i < squares.length; i++ ) {
			
			for ( int j = 0; j < squares[i].length; j++ ) {
				
				// With 30% probability, fill it with an obstacle
				if ( Math.random() < 0.3 ) {
					
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
		
		/* Continue to select new random locations for a player, while
		 * the randomly selected position is already occupied by an obstacle 
		 * or the maze exit
		 */
		do {
			
			playerY = (int)(Math.random() * squares.length);
			
			playerX = (int)(Math.random() * squares[0].length);
			
		} while (squareFilled(playerY, playerX).equals(Color.BLACK) || squareFilled(playerY, playerX).equals(Color.GREEN));
		
		/* Once a suitable X and Y position has been chosen for the player, 
		  fill the selected square with red to represent the player  */
		fillSquare(playerY, playerX, Color.RED);
		
	}
	
	/**
	 * 
	 */
	private void placeMazeExit() {
		
		// Randomly select tile for maze exit, and colour it green
		fillSquare((int)(Math.random() * squares.length), (int)(Math.random() * squares[0].length), Color.GREEN);
		
	}

	/**
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int newPlayerY = playerY;
		
		int newPlayerX = playerX;
		
		// Up
		if ( e.getKeyCode() == 38 ) {
			
			/* Y - 1 is the desired next square, so make sure this does not contain an obstacle,
			 * and ensure that this location is still within the visible space (i.e. not above
			 * the grid)
			 */
			if ( playerY > 0 && !squareFilled(playerY - 1, playerX).equals(Color.BLACK) ) {
				
				newPlayerY--;
				
			}
		
		// Down
		} else if ( e.getKeyCode() == 40 ) {
			
			/* Similar concept as above, except this time make sure that the desired location is not 
			 * below the grid
			 */
			if ( playerY < squares.length - 1 && !squareFilled(playerY + 1, playerX).equals(Color.BLACK) ) {
				
				newPlayerY++;
				
			}
		
		// Left
		} else if ( e.getKeyCode() == 37 ) {
			
			if ( playerX > 0 && !squareFilled(playerY, playerX - 1).equals(Color.BLACK) ) {

				newPlayerX--;
				
			}
		
		// Right
		} else if ( e.getKeyCode() == 39 ) {
			
			if ( playerX < squares[0].length - 1 && !squareFilled(playerY, playerX + 1).equals(Color.BLACK) ) {
				
				newPlayerX++;
				
			}
			
		}
		
		// If the next square contains a green tile, game complete
		if ( squareFilled(newPlayerY, newPlayerX).equals(Color.GREEN) ) {
			
			JOptionPane.showMessageDialog(this, "Game complete!");
			
		}
		
		// Clear the square, initially.
		fillSquare(playerY, playerX, null);
		
		/* And paint a new square for the player (note that this may be the same square if the
		 * player has not moved).
		 */
		fillSquare(newPlayerY, newPlayerX, Color.RED);
		
		// Update the Y and the X of the player to create movement
		playerY = newPlayerY;
		
		playerX = newPlayerX;
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new ObstacleMaze().setVisible(true);
		
	}
	
	// Have to be implemented from interface:
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
