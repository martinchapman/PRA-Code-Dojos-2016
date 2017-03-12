package dojo3.model;

import java.util.Observable;

/**
 * @author Martin
 *
 */
public class MazeModel extends Observable {

	/**
	 * 
	 */
	private int playerY;

	/**
	 * 
	 */
	private int playerX;
	
	/**
	 * 
	 */
	private boolean[][] obstacles;
	
	/**
	 * 
	 */
	private int exitX;
	
	/**
	 * 
	 */
	private int exitY;
	
	/**
	 * 
	 */
	public MazeModel(int width, int height) {
		
		obstacles = new boolean[width][height];
		
		placeObstacles();
		
		placeMazeExit();
		
		placePlayer();
		
	}
	
	/**
	 * 
	 */
	private void placeObstacles() {
		
		// Go through every tile on the grid
		for ( int i = 0; i < obstacles.length; i++ ) {
			
			for ( int j = 0; j < obstacles[i].length; j++ ) {
				
				// With 30% probability, fill it with an obstacle
				if ( Math.random() < 0.3 ) {
					
					obstacles[i][j] = true;
					
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
			
			playerY = (int)(Math.random() * obstacles.length);
			
			playerX = (int)(Math.random() * obstacles[0].length);
			
		} while ( obstacles[playerY][playerX] || ( playerY == exitY && playerX == exitX ) );
		
	}
	
	/**
	 * 
	 */
	private void placeMazeExit() {
		
		exitY = (int)(Math.random() * obstacles.length);
		
		exitX = (int)(Math.random() * obstacles[0].length);
		
	}
	
	public void removePlayer() {
		
		setChanged();
		notifyObservers("remove");
		
	}

	/**
	 * @return
	 */
	public boolean moveUp() {
		
		/* Y - 1 is the desired next square, so make sure this does not contain an obstacle,
		 * and ensure that this location is still within the visible space (i.e. not above
		 * the grid)
		 */
		if ( playerY > 0 && !obstacles[playerY - 1][playerX] ) {
			
			playerY--;
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		setChanged();
		notifyObservers();
		return false;
		
	}
	
	/**
	 * @return
	 */
	public boolean moveDown() {
		
		/* Similar concept as above, except this time make sure that the desired location is not 
		 * below the grid
		 */
		if ( playerY < obstacles.length - 1 && !obstacles[playerY + 1][playerX] ) {
			
			playerY++;
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		setChanged();
		notifyObservers();
		return false;
		
	}
	
	/**
	 * @return
	 */
	public boolean moveLeft() {
		
		if ( playerX > 0 && !obstacles[playerY][playerX - 1] ) {

			playerX--;
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		setChanged();
		notifyObservers();
		return false;
		
	}
	
	/**
	 * @return
	 */
	public boolean moveRight() {
		
		if ( playerX < obstacles[0].length - 1 && !obstacles[playerY][playerX + 1] ) {
			
			playerX++;
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		setChanged();
		notifyObservers();
		return false;
		
	}
	
	/**
	 * @return
	 */
	public boolean checkDone() {
		
		return playerY == exitY && playerX == exitX;
				
	}
	
	public int getPlayerY() {
		
		return playerY;
	
	}

	public int getPlayerX() {
	
		return playerX;
	
	}

	public boolean[][] getObstacles() {
	
		return obstacles;
	
	}

	public int getExitX() {
	
		return exitX;
	
	}

	public int getExitY() {
	
		return exitY;
	
	}
	
}