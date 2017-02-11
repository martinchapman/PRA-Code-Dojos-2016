package dojo2;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * As always, it's good to annotate code you receive from us
 * with your own comments, to help you with your own understanding.
 * 
 * @author Martin
 *
 */
public class Keypad extends JFrame {

	/**
	 * Keeping the compiler happy...
	 */
	private static final long serialVersionUID = 1L;
	
	private int batteryLevel;
	
	/**
	 * 
	 */
	public Keypad() {
		
		FileWriter writer = null;
		
		try {
		
			writer = new FileWriter("output/numbers.txt", true);
			
			writer.close();

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		batteryLevel = 100;
		
		ActionListener clockListener = new ActionListener() {
			  
			public void actionPerformed(ActionEvent e) {
				
				String minute = "" + Calendar.getInstance().get(Calendar.MINUTE);
				
				if ( minute.length() == 1 ) minute = "0" + minute;
				
				Keypad.super.setTitle("O2-UK " + (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) + ":" + minute + "	" + batteryLevel + "%"); 
		    
			}
			
		};
		
		Timer clockTimer = new Timer(60000, clockListener);
		
		clockTimer.start();
		
		ActionListener batteryListener = new ActionListener() {
			  
			public void actionPerformed(ActionEvent e) {
				
				if ( batteryLevel > 0 ) {
				
					batteryLevel--;
			    
				}
				
			}
			
		};
		
		Timer batteryTimer = new Timer(60000, batteryListener);
		
		batteryTimer.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setPreferredSize(new Dimension(400, 600));
		
		setLayout( new BorderLayout() );
		
		north();
		
		centre();
		
		south();
		
		pack();
		
	}
	
	private JLabel number;
	
	/**
	 * 
	 */
	private void north() {
		
		JPanel numberOutput = new JPanel();
		
		add( numberOutput, BorderLayout.NORTH );
		
		//
		
		numberOutput.setLayout( new BorderLayout() );
		
		//
		
		JButton add = new JButton("+");
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( batteryLevel == 0 ) return;
				
				FileWriter writer = null;
				
				try {
					
					Scanner input = new Scanner(new File("output/numbers.txt"));
					
					while ( input.hasNext() ) {
						
						if ( input.next().equals(number.getText()) ) {
							
							input.close();
							
							return;
							
						}
						
					}
				
				    input.close();
				    
					writer = new FileWriter("output/numbers.txt", true);
					
					writer.append(number.getText() + "\n");
					
				    writer.flush();
				    
				} catch (IOException ioException) { 
					
					ioException.printStackTrace();
					
				}
				
			}
		
		});
		
		numberOutput.add( add, BorderLayout.WEST );
		
		//
		
		number = new JLabel("");
		
		number.setHorizontalAlignment(SwingConstants.CENTER);
		
		numberOutput.add( number, BorderLayout.CENTER );
		
		//
		
		JButton delete = new JButton("<");
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( batteryLevel == 0 ) return;
				
				if ( number.getText().length() > 0 ) {
				
					number.setText(number.getText().substring(0, number.getText().length() - 1));
				
				}
				
			}
			
		});
		
		numberOutput.add( delete, BorderLayout.EAST );
		
	}
	
	/**
	 * 
	 */
	private void centre() {
		
		JPanel centre = new JPanel();
		
		centre.setLayout(new BorderLayout());
		
		add(centre, BorderLayout.CENTER);
		
		dialPad(centre);
		
		callButton(centre);
		
	}
	
	/**
	 * @param centre
	 */
	private void dialPad( JPanel centre ) {
		
		JPanel dialPad = new JPanel();
		
		centre.add(dialPad, BorderLayout.CENTER);
		
		dialPad.setLayout( new GridLayout(4, 3) );
		
		char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		for ( int number = 1; number <= 12; number++ ) {
			
			switch ( number ) {
				
				case 10: dialPad.add(new JButton("*")); break;
				
				case 11: dialPad.add(new JButton(0 + " (+)")); break;
				
				case 12: dialPad.add(new JButton("#")); break;
				
				case 1: dialPad.add(new JButton(number + "")); break;
			
				case 9: dialPad.add(new JButton(number + " (WXYZ)")); break;
			
				case 8: dialPad.add(new JButton(number + " (TUV)")); break;
				
				case 7: dialPad.add(new JButton(number + " (PQRS)")); break;
				
				default: dialPad.add(new JButton(number + " (" + (letters[((number-2)*3)]) + (letters[((number-2)*3)+1]) + (letters[((number-2)*3)+2]) +")")); break;
				
			}
			
		}
		
		dialPadListeners(dialPad);
		
	}
	
	private void dialPadListeners( JPanel dialPad ) {
		
		HashMap<String, Long> buttonPresses = new HashMap<String, Long>();
		
		for ( Component button : dialPad.getComponents() ) {
			
			if ( button instanceof JButton ) {
				
				((JButton) button).addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if ( batteryLevel == 0 ) return;
						
						// If we have a record of when this number (on the dial pad) was last pressed
						if ( buttonPresses.containsKey(((JButton)button).getText()) ) {
							
							// Check whether that record tells us that this number was pressed less than 400 MS ago (or if a single character button is pressed)
							if ( ((JButton)button).getText().length() > 1 && System.currentTimeMillis() - buttonPresses.get(((JButton)button).getText()) < 400 ) {
								
								/* If it was, find the index of the character that was just added to
								 * the number output in the button label (e.g. if 1 is in the number output,
								 * its index would be 0) and add one to it, with the purpose of cycling through
								 * the numbers and characters shown, when a button is pressed repeatedly
								 */
								int indexInButtonText = 
									((JButton)button).getText().indexOf(
										number.getText().charAt(number.getText().length() - 1)
									)
									+ 1;
								
								// Take a temporary record of the next character in the button label
								String nextCharacter = ((JButton)button).getText().charAt(indexInButtonText) + "";
								
								// If a character in the button label isn't one we want to display, skip it
								while ( nextCharacter.equals(" ") || nextCharacter.equals("(") || nextCharacter.equals(")") ) {
									
									indexInButtonText++;
									
									// Loop back to the first character on a button if the last one is reached.
									if ( indexInButtonText >= ((JButton)button).getText().length() ) {
										
										indexInButtonText = 0;
										
										break;
									
									}
									
									nextCharacter = ((JButton)button).getText().charAt(indexInButtonText) + "";
									
								}
								
								// Update the content in the number output based upon the desired index
								number.setText(
									number.getText().substring(0, number.getText().length() - 1) +
										((JButton)button).getText().charAt(
											indexInButtonText
										)
								);
						
							} else {
								
								/* If there is no record of a previous button press or the number is
								 * pressed at normal speed, add a number to the number output as normal
								 */
								number.setText(number.getText() + ((JButton)button).getText().charAt(0));

							}
							
						} else {
							
							number.setText(number.getText() + ((JButton)button).getText().charAt(0));
							
						}
						
						buttonPresses.put(((JButton)button).getText(), System.currentTimeMillis());
						
					}
					
				});
				
			}
			
		}
		
	}
	
	/**
	 * @param centre
	 */
	private void callButton( JPanel centre ) {
		
		centre.add( new JButton("\u260E"), BorderLayout.SOUTH);
		
	}
	
	/**
	 * 
	 */
	private void south() {
		
		JPanel south = new JPanel();
		
		add(south, BorderLayout.SOUTH);
		
		south.setLayout(new GridLayout(2, 5));
		
		south.add(new JButton("\u2605"));
		
		south.add(new JButton("\u25F4"));
		
		south.add(new JButton("\uC6C3"));
		
		south.add(new JButton("\u260E"));
		
		south.add(new JButton("\u2315"));
		
		JLabel favourites = new JLabel("Favourites");
		
		favourites.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel recents = new JLabel("Recents");
		
		recents.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel contacts = new JLabel("Contacts");
		
		contacts.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel keypad = new JLabel("Keypad");
		
		keypad.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel voicemail = new JLabel("Voicemail");
		
		voicemail.setHorizontalAlignment(JLabel.CENTER);
		
		south.add(favourites);
		
		south.add(recents);
		
		south.add(contacts);
		
		south.add(keypad);
		
		south.add(voicemail);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Keypad().setVisible( true );
		
	}

}
