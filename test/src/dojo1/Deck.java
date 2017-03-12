package dojo1;
/**
 * @author Martin
 *
 */
public class Deck {

	/**
	 * Array of cards (fixed size)
	 */
	private Card[] cards;
	
	/**
	 * Where the top of the deck is (i.e. the top, face down card on
	 * a pile of face down cards), and therefore where to take the 
	 * next card from.
	 * 
	 * Starts at 0.
	 */
	private int topOfDeck;

	/**
	 * Construct the deck.
	 */
	public Deck() {
	   
		// 52 cards in a deck.
		cards = new Card[52];
      
		/* Deck start off empty (so first card to be added is at position 0 in the array).
		 * Temporary variable. Can imagine filling from top of deck (top face down card) through
		 * to bottom of deck.
		 */
		int nextCard = 0;
      
		// For all 4 suits
		for ( int suit = 1; suit < 5; suit++) {
         
			// and all 13 values (Ace, 2 - 10, Jack, Queen King).
			for ( int value = 1; value < 14; value++ ) {
    		  
				// add a new Card object with this information.
				cards[nextCard++] = new Card( value, suit );
         
			}
    	  
		}
   
	}

	/**
	 * @return The number of cards remaining in the deck.
	 */
	public int cardsLeft() {
	   
		return 52 - topOfDeck;
   
	}

	/**
	 * @return Take a card from the top of the deck (i.e. first face down card).
	 */
	public Card dealOne() {
	   
		return cards[topOfDeck++];
   
	}

	/**
	 * Shuffle the cards (form of https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle).
	 */
	public void shuffle() {
	    
		// For the number of cards that there are currently in the deck
		for ( int card = 0; card < cardsLeft(); card++ ) {
			
			/* make a random selection between 0 and the number of remaining cards,
			 * and then shift up so that lower end of the random selection is the first 
			 * available card at the top of the deck, and the upper end of the random 
			 * selection is 51 (52nd card). 
			 * 
			 * So full range is between top and end of the deck. e.g. 
			 * 
			 * In a full deck, is between 0 (top of deck) and 51.
			 * 
			 * In a deck with five dealt cards, is between 5 (top of deck) and 51.
			 */
			int randomPositionInDeck = (int)(Math.random() * cardsLeft()) + topOfDeck;
			
			// Save the current card.
			Card currentCard = cards[card];
         
			// Switch a randomly selected position with another card.
			cards[card] = cards[randomPositionInDeck];
         
			// Place the current card in that randomly selected position.
			cards[randomPositionInDeck] = currentCard;
        
		}
      
	}  
   
}