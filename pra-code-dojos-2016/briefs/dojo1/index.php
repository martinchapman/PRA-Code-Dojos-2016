<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
?>

<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Code Dojo 1</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="https://fonts.googleapis.com/css?family=Fira+Sans" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">

</head>
<body>

  <!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <div class="container">

    <div class="row">

      <div class="two-thirds column" style="margin-top: 5%">

        <h4>Code Dojo 1: `All in'</h4>
		
		<h5>Overview</h5>
		
		<p>In your first dojo, your task is to work as a group to develop a program that aims to find the first hand that is dealt in the game of poker that contains a flush, when cards are repeatedly dealt from a shuffled deck. Once such a hand is found, we want to order it, and then display this hand to the user.</p>
		
		<p>Therefore, there are several key pieces of functionality that your program should offer:</p>
		
		<ol>
			
			<li>The ability to shuffle a deck of cards.</li>
			
			<li>The ability to sort a hand of cards.</li>
			
			<li>The ability to identify when a hard of cards is a flush.</li>
			
			<li>For practice, and if there's time, the ability to identify another type of poker hand, such as a straight.</li>
			
		</ol>
		
		<p>There are a variety of different ways to construct a program that performs this task, and as with all dojo sessions, there is no expectation that you will construct a complete solution, or a solution that performs the stated function exactly. As they say, it's about the journey, not the destination.</p>
		
		<h5>Playing poker</h5>
		
		<h6>The details of the game of poker that ought to be captured by your program in order to complete this task are as follows:</h6>
		
		<ul>
			
			<li>In a standard deck, there are 52 cards. There are four suits: Spades, Hearts, Clubs and Diamonds.</li>
			
			<li>Within each suit, there are 13 cards, each of which has a corresponding value: An Ace (1), value cards 2 - 10, a Jack (11), a Queen (12) and a King (13).</li>
			
			<li>A hand in poker consists of 5 cards.</li>
			
			<li>When a hand is sorted, all the cards in a suit are ordered numerically, in ascending order of value from left to right*. The order of the suits in a hand can be chosen arbitrarily.</li>
			
			<li>*In our scenario, aces in a hand are treated as high, such that despite their value being 1, when that hand is sorted, any aces should appear <i>after</i> all the other cards in that suit (i.e. to the right of these cards). For example, the hand (9 of Spades; 4 of Diamonds; Ace of Diamonds; Ace of Clubs; Jack of Diamonds) would be sorted as (9 of Spades; Ace of Clubs; 4 of Diamonds; Jack of Diamonds; Ace of Diamonds;).</li>
			
			<li>A player has a flush when they have 5 cards of the same suit.</li>
			
			<li>A player has a straight when they have 5 cards with sequential values in their hand. For simplicity, you can ignore the presence of aces, which can be either low or high in a straight.</li>
			
		</ul>
		
		<h5>Other considerations</h5>
		
		<h6>Things you should consider when developing your solution are:</h6>
		
		<ul>
			
			<li>How to efficiently represent the value and suit of an individual card.</li>
			
			<li>How the internal representation of the value and the suit of a card be translated into a neat string representation. Ideally, we want to be able to see text like `5 of Hearts', when inspecting an individual card, regardless of how this information is stored internally by the card. Similarly, we want to be able to see a list of 5 cards when we print a hand.</li>
			
			<li>How to compare one card to another, when we wish to order a hand of cards. You'll need to factor in both the suit of the card, the value of the card and the difference between the value of an ace and the position in which it should appear in a hand of cards when sorted.</li>
			
			<li>How to sort a hand of cards, given the ability to compare two cards. You may wish to consider two ways in which to do this: first of all you may wish to perform a <a href="https://en.wikipedia.org/wiki/Selection_sort">manual sort</a>, for practice, and then a simple automatic sort.</li>
			
			<li>How to efficiently identify when a hand is a flush (or other poker hands, if there is time).</li>
			
			<li>How to shuffle a deck. There are some <a href=" https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">simple, standard shuffling algorithms</a> that could be replicated in your solution.</li>
			
			<li>How to transfer cards from a deck to a player's hand.</li>
			
			<li>How your main method needs to be structured in order to find the desired hand, and print it out: which objects need to be created? which actions need to be iterated?</li> 
			
		<ul>
		
	  
	  </div>
	
	  <div class="one-third column" style="margin-top: 5%; font-size: 14px;">

		<p>Please review the document marked `<a href="https://keats.kcl.ac.uk/pluginfile.php/2280237/mod_resource/content/1/WhatIsACodeDojo%3F.pdf">What is a Code Dojo?</a>' on KEATS before attending your first small group tutorial session.</p>
		
		<p>If you have any feedback about the format of your small group tutorial sessions, please let us know: <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk</a>.</p> 
		
		<p>If there are reasons noted in your KIP (if you are unaware of what a KIP is, then this instruction does not apply to you), or hitherto undisclosed reasons, that would make participating in the session in the proposed way difficult or impossible, please also let us know via the usual support channels.</p>
  
      </div>
	
	</div>
  
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
