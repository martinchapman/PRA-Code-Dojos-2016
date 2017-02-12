<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
?>

<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Code Dojo 2</title>
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

        <h4>Code Dojo 2: `Stop callin', stop callin', I don't wanna code anymore.'</h4>
        
         <p>In this  dojo,  working  together  as a group,  you will first work out  how best  to replicate  Apple’s iOS keypad,  as shown below (sorry Android  users), before adding functionality to this keypad.</p>
		
		<p><a href="images/phone.jpg"><img src="images/phone.jpg" class="u-max-full-width" /></a></p>
		
		<h5>Frames, Components and Layout Managers</h5>
		
		<p>You should now be familiar with the concept of a  frame, and with the concept of components,  and  layout  managers  that can be used to position  those  components  in a certain  way.  
		
		<p>You should use this knowledge to reconstruct the keypad.</p>
		
		<p>It’s likely that your finished product  won’t look exactly like the graphic shown (who could replicate  the  glamorous  UX offered by Apple),  but the  key thing  is the  components,  and their  relative  positions.</p>
		
		<p>For symbols, you can use keyboard punctuation (e.g. &lsaquo;), or you might like to consider using Unicode symbols that can be rendered  by Java  (see <a href="http://www.ssec.wisc.edu/~tomw/java/unicode.html">here</a> and <a href="http://www.fileformat.info/info/unicode/char/search.htm">here</a>).
		
		<p>Below, I have given a proposed  top-level division of the frame into panels:</p>

		<p><a href="images/phone-annotated.jpg"><img src="images/phone-annotated.jpg" class="u-max-full-width" /></a></p>
	
	  </div>
	  
	  <div class="one-third column" style="margin-top: 5%; font-size: 14px;">

		<p>Please review the document marked `<a href="https://keats.kcl.ac.uk/pluginfile.php/2280237/mod_resource/content/1/WhatIsACodeDojo%3F.pdf">What is a Code Dojo?</a>' on KEATS before attending your first small group tutorial session.</p>
		
		<p>If you have any feedback about the format of your small group tutorial sessions, please let us know: programming@kcl.ac.uk.</p> 
		
		<p>If there are reasons noted in your KIP (if you are unaware of what a KIP is, then this instruction does not apply to you), or hitherto undisclosed reasons, that would make participating in the session in the proposed way difficult or impossible, please also let us know via the usual support channels.</p>
  
      </div>
	
	</div>
	
	<div class="row">

      <div class="two-thirds column" style="margin-top: 5%">
	
		<h5>Action Listeners</h5>
		
		<p>Next you will be bringing  life to the  static smartphone keypad.</p>
		
		<p>The basic functionality I want you to add to the keypad  is as follows:</p>
		
		<ol>
		
			<li>When each button is pressed, the number  associated  with that button should appear in the number  output field.</li>
			
			<li>When  the  delete  button is pressed  (<),  the  last  number  in the  number  output field should be removed.</li>
			
			<li>Make  the  clock at  the  top  of the  frame  real,  so that it  advances  every  minute  in accordance  with  the  actual  time.    Hint:   The classes <span class="code">javax.swing.Timer</span> and  <span class="code">java.util.Calendar</span> should help you with this task.</li>
			
			<li>Using the  same idea,  make  the  battery (which  should  start at  100%) drain  by 1% every minute  (to  accurately replicate  the  average  battery life of an iPhone).   Make sure the battery level does not fall below zero. If the battery is at 0% all features of the dial pad (e.g.  entering  numbers,  deleting  numbers  etc.)  should be disabled.</li>
		
		</ol>
		
		<p>If you have time, explore the following advanced  functionality:</p>
		
		<ol>
		
			<li>When  the  store  button is pressed  (+) any numbers  currently in the  number  output field should  be stored  to  a specific file.  Only  sets  of numbers  that do not  already exist in this file should be stored.</li>
			
			<li>In the  era before smartphones, we had  to press a button multiple  times  in order  to show a letter,  typically when writing  a text  message.  For example,  pressing the key ‘2’ once would show a ‘2’ in the associated  output area, but if the key ‘2’ was pressed again,  quickly, then  the ‘2’ in the output area would transform into an ‘A’. Pressing the  ‘2’ button again,  quickly, would transform this  ‘A’ into  a ‘B’, and  so on for the remaining  characters on the  ‘2’ key.  Thus,  pressing  the  same key multiple  times  in short  succession would allow you to display each potential piece of output from that key, on a loop (i.e.  when pressing ‘2’, once ‘C’ is displayed,  pressing ‘2’ again would transform this ‘C’ back into a ‘2’, because there  are no further  characters associated with  the  key ‘2’, so we start again from the  beginning).   Pressing  a button multiple times  with a sufficient pause in between  each press would output the numeric  value associated  with that button multiple  times as normal.</li>
			
			<p>Let’s forget that Apple use this  dial pad  to only enter  phone numbers,  and  try  and replicate  the  functionality described  above  in the  GUI: pressing  a dial  pad  button once, or with a sufficient pause between multiple  presses, should show the associated number(s) as normal in the number output field. However, pressing this button again, quickly,  should  transform the  output number  into  the  first  character it  represents, and  then  into  the  second when the  number  is pressed  again,  and  so on.  To give an additional example to the one above, pressing the key ‘8’ once should show ‘8’ in the number  output, then  pressing  ‘8’ quickly again should transform this  ‘8’ into  a ‘T’. If ‘8’ is pressed, then  the user pauses before pressing ‘8’ again, another  ‘8’ should be added  to the number  output as normal.</p>
		
			<p>You should avoid printing  spaces or parenthesis to the number  output.</p>
		
			<p>Even if you cannot  implement this functionality directly,  discuss with the rest of your group about  how you might do so, and which datastructures and method  calls would support your solution.</p>
			
		</ol>
	
	  </div>
	
	  <div class="one-third column" style="margin-top: 5%; font-size: 14px;">

		<p>In this dojo I want  you to think  carefully about  efficiency, and  how you can avoid code duplication.</p>
		
		<p>You should also bear in mind a separation between the `view' (what is seen) and the `model' (the state that is stored) in your solution.</p>
		
      </div>
	
	</div>
  
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
