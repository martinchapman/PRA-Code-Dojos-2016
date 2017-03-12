package dojo3.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dojo3.model.MazeModel;

/**
 * @author Martin
 *
 */
public class MazeListener implements KeyListener {

	/**
	 * 
	 */
	private MazeModel model;
	
	/**
	 * @param model
	 */
	public MazeListener(MazeModel model) {
		
		this.model = model;
		
	}

	/**
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		model.removePlayer();
		
		// Up
		if ( e.getKeyCode() == 38 ) {
			
			model.moveUp();
		
		// Down
		} else if ( e.getKeyCode() == 40 ) {
			
			model.moveDown();
		
		// Left
		} else if ( e.getKeyCode() == 37 ) {
			
			model.moveLeft();
		
		// Right
		} else if ( e.getKeyCode() == 39 ) {
			
			model.moveRight();
			
		}
		
	}

	// Unused methods:
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}