package dojo1;
/**
 * The representation of a single card.
 * 
 * We implement Comparable to allow `SortB' to occur in a CardHand.
 * 
 * @author Martin
 *
 */
public class Card implements Comparable<Card >{
	
	/**
	 * The value of this card (e.g. 2, 3, Jack).
	 */
	private int value;
	
	/**
	 * The suit of this card (e.g. Spades, Hearts),
	 * as a numerical representation.
	 */
	private int suit;

   	
   	/**
   	 * @param value The value of the card.
   	 * @param suit The suit of the card, as a numerical representation.
   	 */
   	public Card( int value, int suit ) {
	   
   		this.value = value;
   		this.suit = suit;
   
   	}

   	/* (non-Javadoc)
   	 * @see java.lang.Object#toString()
   	 */
   	public String toString() {
	   
   		String output = "";
        
   		// Translate the value to a face card name, if necessary.
   		switch ( value ) {
      
   			case 1: output = "Ace"; break;
   			case 11: output = "Jack"; break;
   			case 12: output = "Queen"; break;
   			case 13: output = "King"; break;
   			default: output = "" + value; break;
      
   		}
      
   		output = output + " of ";
      
   		// Translate the suit to its name.
   		switch ( suit ) {
      
   			// Ordering here is arbitrary.
   			case 1: output += "Spades"; break;
   			case 2: output += "Hearts"; break;
   			case 3: output += "Clubs"; break;
   			case 4: output += "Diamonds"; break;
      
   		}
      
   		return output;
   
   	}

   	/**
   	 * @return The value of this card.
   	 */
   	public int getValue() {
   		
      return value;
   	
   	}

   /**
    * @return The suit of this card.
    */
   	public int getSuit() {
	   
      return suit;
   
   }

   /* (non-Javadoc)
    * @see java.lang.Comparable#compareTo(java.lang.Object)
    * 
    * Compare CardA to CardB. Negative values indicate that CardA
    * comes before CardB in a hand of cards (i.e. CardB has a higher value than CardA); 
    * positive values indicate that CardB comes before CardA in a hand of cards 
    * (CardA comes after CardB) (i.e. CardA has a higher value than CardB).
    */
   public int compareTo(Card card) {
	   
	  /* Check by suit first, using arbitrary ordering. If suits are not the same,
	   * no need to look at value.
	   */
      if (suit < card.suit) return -1; 
      if (suit > card.suit) return 1;
      
      // Aces are high, so CardA always appears after CardB if CardA is an ace.
      if (value == 1) return 1; 
      
      // If CardB is an ace, then CardA always appears before.
      if (card.value == 1) return -1; 
      
      /* Standard subtraction mechanism to determine if one integer comes before another,
       * in all other cases.
       */
      return (value - card.value); 
      
   }
}