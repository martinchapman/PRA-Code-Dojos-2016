package Dojo1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * As always, it's good to annotate code you receive from us
 * with your own comments, to help you with your own understanding.
 * 
 * @author Martin
 *
 */
public class Keypad extends JFrame {

	/**
	 * Keeping the compiler happy by offering a way
	 * to identify serialised objects of this class.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Keypad() {
		
		super("O2-UK			19:26			33%");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setPreferredSize(new Dimension(400, 600));
		
		setLayout( new BorderLayout() );
		
		north();
		
		centre();
		
		south();
		
		pack();
		
	}
	
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
		
		numberOutput.add( add, BorderLayout.WEST );
		
		//
		
		JLabel number = new JLabel("020 7848 1789");
		
		number.setHorizontalAlignment(SwingConstants.CENTER);
		
		numberOutput.add( number, BorderLayout.CENTER );
		
		//
		
		JButton delete = new JButton("<");
		
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
			
			if ( number == 10 ) {
				
				dialPad.add(new JButton("*"));
				
			} else if ( number == 11 ) {
				
				dialPad.add(new JButton(0 + " (+)"));
				
			} else if ( number == 12 ){
				
				dialPad.add(new JButton("#"));
				
			} else if ( number == 1 ) {
				
				dialPad.add(new JButton(number + ""));
			
			} else if ( number == 9 ) {
				
				dialPad.add(new JButton(number + " (WXYZ)"));
			
			} else if ( number == 8 ) {
				
				dialPad.add(new JButton(number + " (TUV)"));
				
			} else if ( number == 7 ) {
				
				dialPad.add(new JButton(number + " (PQRS)"));
				
			} else {
				
				dialPad.add(new JButton(number + " (" + (letters[((number-2)*3)]) + (letters[((number-2)*3)+1]) + (letters[((number-2)*3)+2]) +")"));
				
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
