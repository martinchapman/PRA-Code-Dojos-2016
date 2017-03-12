<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
?>

<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Code Dojo 3</title>
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

        <h4>Code Dojo 3: `A-maze-ing Java.'</h4>
        
         <p>During this Code Dojo, you will start to implement a simple maze game, similar to the one shown below. It is not expected that you will finish this implementation, but you should be able to make a good start during the Dojo. You should finish this maze game off during your own time for practice.</p>
		
		<p><a href="images/maze.png"><img src="images/maze.png" class="u-max-full-width" /></a></p>
		
		<h5>Rules of the game</h5>
		
		<p>In our maze game, the board is split into a grid of tiles. Tiles can either be black, which represents an obstacle or a wall of the maze; red, which represents the players current position; green which represents the exit of the maze; or empty, which represents free space in which the player can move. The objective of the game is to move the red tile (the player) to be at the same position as the green tile, thus exiting the maze, while navigating around the obstacles.</p>

		<p>A class <span class="code">PlayerGrid</span> is provided for you <a href="PlayerGrid.class">here</a>. You should extend this class to allow you to create and modify a frame filled with a grid of coloured tiles in your application.</p>
  		
  		<p>Create an empty grid by invoking the super constructor of <span class="code">PlayerGrid</span>, with a specified number of rows and columns, and a specified size of the frame.</p>
		
		<p>Your program will then need to exhibit the following functionality:</p>
		
		<ol>
		
			<li>When setting up the game, your program should loop through each tile on the grid, and with a certain probability fill that tile with an obstacle. Note that because this results in the random placement of obstacles, it may be the case that a player can never reach the exit of the maze (i.e. they blocked in). This is not a scenario that we will explicitly account for in our implementation.</li>
			
			<li>Once the obstacles have been placed, your program should place the maze exit. It does not matter if this involves changing a tile that previously held an obstacle (i.e. a tile that was previously black) to the maze exit.</li>
			
			<li>Once the exit has been placed, your program should place the player at a random position on the grid. Note that a player should not be placed on top of an obstacle or on top of the exit.</li>
			
			<li>When the appropriate key – either up, down, left or right – is pressed on the keyboard of the computer running your application, your player should move in the direction denoted by that key. Before moving the player to the next tile in the specified direction, your program should check if the destination tile contains an obstacle. If it does not, then the player should not move in that direction. Note that you will need to use a <span class="code">KeyListener</span> to read keyboard input from the user, and the <span classkeyCodes 38, 40, 37 and 39 are up, down, left and right, respectively.</li>
			
			<li>It should not be possible to move the player off the edge of the window at any point.</li>
			
			<li>Your program should display a message box congratulating the user once they reach the exit of the maze.</li>
		
		</ol>

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
