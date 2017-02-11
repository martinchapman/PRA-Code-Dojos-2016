package dojo1;
/**
 * Aims to find the first randomly dealt straight or flush in a Poker hand.
 * 
 * @author Martin
 *
 */
public class Main {

	/**
    * @param args
    */
	public static void main(String args[]) {
	  
	  // An empty card hand
	  CardHand cardHand;
	  
	  do {
    	 
		 System.out.println("=======================");
		 
		 // Construct new deck.
         Deck deck = new Deck();
         
         // Construct card hand to hold five cards.
         cardHand = new CardHand(5);
         
         // Shuffle the deck prior to sorting.
         deck.shuffle();
         
         // Add five cards into hand.
         cardHand.deal(deck);
         
         // Print the hand, pre-sorted.
         System.out.println("Unsorted hand: " + cardHand);
         
         // Sort the hand.
         cardHand.sortB();
         
         // Print the hand, post-sorted.
         System.out.println("Sorted hand: " + cardHand);
     
      // Keep going until a flush is found (can switch in straight to test).
	  } while ( !cardHand.isStraight() );
	  
	  // Print out the hand that contains a flush.
	  System.out.println(cardHand);
 
   }

}