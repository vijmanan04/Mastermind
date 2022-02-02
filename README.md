# Mastermind

From Wikipedia: Mastermind or Master Mind is a code-breaking game for two players. The modern game with pegs was invented in 1970 by Mordecai Meirowitz, an Israeli postmaster and telecommunications expert.[1][2] It resembles an earlier pencil and paper game called Bulls and Cows that may date back a century or more.

# Red, Yellow, Orange, Green, Blue, Purple, White
# Scoring Black, White

Mastermind.  (Main.java class if using Repl.it but ok)
*Make a game class
**gives rules at beginning (could be a method call printRules() )
**Scanner class - input user prompts, etc
***would make calls to methods to guess position
***return for this? int[#cPcL][#cPwL]
**Instructions - capture instructions (for text file and UI)\
**?PvP = play1 choses secret code (swap places at keyboard)
***play2 - takes turn guessing
**?PvC	= play1 - computer randomizes colors and location of pins				
***play2 - takes turn guessing
		
*Make a board Class
**Pins - Encoding colors - do we use ints or chars?
**[R, G, Y, O]   [R, B, Y, G]  [2][1]
**[R, G, Y, O]   [R, O, Y, G]  [2][2]   
**int - translate btwn colors
**chars - individual letter

|  | PROS| CONS |
|Ints|-simple to code | -translate back and forth |
|   |		     |-might be confusing to player|
|chars| -less confusion for player | -a bit more code to learn |	 

*Arrays - 1-2D array for player guesses
	**1-1D array for the secret code
	
	
	
# UPDATE TO README
**In this project, I re-created the game MasterMind on a computer terminal. There were many difficulties I came across when programming the game. **Firstly, it was getting used to using ArrayLists as opposed to arrays to print the MasterMind board, populate the board, and other necessary 
**mutation functions on the array lists. Furthermore, the nested structure of the ArrayList made the accesing of elements and adding of elements more complicated, however, now I am pretty comfortable with using them. 

**In terms of the gameplay, I used a mentality where I imagined that I was playing the game, so that I could easily mentally walk through the what elements of the game needed to be programmed. This process also allowed me to focus on the user interaction that a player would have with the computer, so I was able to design the game in a way that was comfortable for the player to interact with. Because of this mentality, I believe that I was able to create more compelling UI than I would have had I approached this problem the way I usually appraoched other programming tasks.

**The most challening aspect of this code was the scoring mechanisms when checking with repeats. I was initially trying to make my code efficent by checking using loop structures instead of multiple if-statements. However, I realized that I would need to keep a counter of each color placed by the user using multiple if-statments if I wanted the repeat functionality in the game. 

**The evolving process in this project involved multiple iterations. First, I focused on making the board and understanding how ArrayLists worked. Then, I focused on programming all the functions that I would need in the game as well as integrating them into the driver code to make sure they were working as intended. As I finsihed more functions, I was able to use the results from the last function as an input into the next function, which mades processing the inputs much easier (e.x. checking that the user inputted a valid string). After the main functions were made, I put everything together in the driver code to put the game together. After this process, I debugged the code and worked on the user interface. 

