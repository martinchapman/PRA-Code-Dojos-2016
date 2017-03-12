import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * Supplied class for Small Group Tutorial 3. Creates a grid with coloured squares.
 * 
 * @author Martin
 *
 */
public class PlayerGrid extends JFrame {
	
	/**
	 * Keeping the compiler happy...
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected Color[][] squares;
	
	/**
	 * 
	 */
	protected int tileWidth;
	
	/**
	 * 
	 */
	protected int tileHeight;
	
	/**
	 * 
	 */
	private int heightOffset;
	
	/**
	 * Specify the number of rows and columns that should appear in this grid,
	 * in addition to the width and height of the visible window.
	 * 
	 * @param rows
	 * @param columns
	 * @param windowWidth
	 * @param windowHeight
	 */
	public PlayerGrid( int rows, int columns, int windowWidth, int windowHeight ) {
		
		squares = new Color[rows][columns];
		
		setSize(windowWidth, windowHeight);
		
		tileHeight = getSize().height / squares.length;
		
		tileWidth = getSize().width / squares[0].length;
		
		// You might need to play with this depending on OS.
		heightOffset = (int)(tileHeight + (tileHeight * 0.4));
	
	}
	
	/**
	 * Fill a square of the grid with a particular coloured tile.
	 * 
	 * @param row
	 * @param column
	 * @param color
	 */
	protected void fillSquare(int row, int column, Color color) {
		
		squares[row][column] = color;
		
		repaint();
		
	}
	
	/**
	 * Find the colour of the tile on a given square of the grid
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	protected Color squareFilled(int row, int column) {
		
		if ( squares[row][column] == null ) return Color.GRAY;
		
		return squares[row][column];
		
	}
	
    /* (non-Javadoc)
     * @see java.awt.Window#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
    
    	super.paint(g);
        
    	for ( int row = 0; row < squares.length; row++ ) {
    		
    		for ( int column = 0; column < squares[row].length; column++ ) {
    			
    			if ( squares[row][column] != null ) {
    			
    				Color c = null;
    			
    				g.setColor(squares[row][column]);
    			
    				g.fillRect(column * tileWidth, row * tileHeight + heightOffset, tileWidth, tileHeight);
    			
    			}
    			
    		}
    		
    		
    	}
    
    }
	
}