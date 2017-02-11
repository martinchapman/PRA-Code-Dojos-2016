package dojo1;
import java.util.Comparator;
import java.util.Arrays;

/**
 * A hand of cards.
 * 
 * Use of `CardHand' over `Hand' clarifies to what objects this class refers.
 * 
 * @author Martin
 *
 */
public class CardHand {

   /**
    * A set of cards in a hand (like a deck but smaller).
    */
	private Card[] hand;
	
	/**
	 * The specified size of the hand (depending on the game being played).
	 */
	private int size;

	/**
	 * Setup the hand.
	 * 
	 * @param size The number of cards in the hand.
	 */
	public CardHand(int size) {
	   
		this.size = size;
		hand = new Card[size];
   
	}

	/**
	 * Add a card to the hand, as extracted from a
	 * Deck object consisting of Card objects.
	 * 
	 * @param deck The Deck from which to deal the cards.
	 */
	public void deal(Deck deck) {
	   
		for ( int position = 0; position < size; position++ ) {
    	  
			/* Extract a Card object from the supplied Deck object,
			 * and place it into the next position in the hand.
			 */
			hand[position] = deck.dealOne();
      
		}
      
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Show the cards currently in the hand, side-by-side
	 * separate by a semi-colon.
	 */
	public String toString() {
	   
		String output = "";
      
		for ( int card = 0; card < size; card++ ) {
			
			output = output + hand[card] + "; ";
		
		}
      
		return output;
   
	}

	/**
	 * Simple selection sort for the hand (https://en.wikipedia.org/wiki/Selection_sort)
	 */
	public void sortA() {
     
		// Look at each card in the hand from left to right.
		for ( int currentCard = 0; currentCard < size; currentCard++ ) {
    	  
			// Go through the remaining cards to the right of the current card.
			for ( int remainingCard = currentCard + 1; remainingCard < size; remainingCard++) {
             
				/* If remaining card (CardB) should come before current card (CardA), as indicated
				 * by resulting being positive (zero indicates equality), then cards need to be switched.
				 */
				if ( hand[currentCard].compareTo(hand[remainingCard]) > 0 ) {
					
					// Save this card.
					Card thisCard = hand[currentCard];
					
					// Bring remaining card into current card's position (earlier in the hand; to the left).
					hand[currentCard] = hand[remainingCard];
					
					// Place current card in remaining card's position (later in the hand; to the right).
					hand[remainingCard] = thisCard;
             
				}
        	 
			}
         
		}
	   
	}

	/**
	 * Faster way to sort when Card is of Comparable type.
	 */
	public void sortB() {
	   
		Arrays.sort(hand);
   
	}

	/**
	 * @return Whether this hand constitutes a flush (all cards of the same suit).
	 */
	public boolean isFlush() {

		// Starting at the second card
		for ( int i = 1; i < size; i++ ) {
			
			/* If the suit of the card that comes before the current one 
			 * is not the same as the suit of the current card, hand is not a flush.
			 */
			if ( hand[i].getSuit() != hand[0].getSuit() ) {
        	 
				return false;
         
			}
      
		}
	  
		// Otherwise, return true.
		return true;
   
	}

	/**
	 * For simplicity, we will not consider the behaviour of the ace, which can either
	 * be low or high in poker.
	 * 
	 * @return Whether this hand constitutes a straight.
	 */
	public boolean isStraight() {
	    
		// Starting at the second card
		for ( int i = 1; i < size; i++ ) {
         
			/* If the value of the current card is not the same as the value
			 * of the card that came before it plus one (i.e. the current card
			 * is not the numerically sequential progression of the previous one),
			 * then hand cannot be straight.
			 */
			if ( hand[i].getValue() != hand[i - 1].getValue() + 1 ) {
    		 
				return false;
         
			}
    	 
		}
      
		// Otherwise, return true.
		return true;
   
	}
  
}