/*
 * Game.java
 *
 * Copyright 2022 Manan Vij <vijman22@US-CompLabiMac-16.local>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */
import java.util.Scanner;



public class Game {
	public static void main (String[] args) {

		int redPins;
		MasterMind game = new MasterMind();
		Scanner scan = new Scanner(System.in);
		String ans;
		String mode;

		game.setBoard();
		
		// Print intro screen and user interface
		game.printIntro();
		System.out.print("Press enter to continue .... \n\n");
		ans = scan.nextLine();
		game.printRules(1);
		System.out.print("Press enter to continue .... \n\n");
		ans = scan.nextLine();
		game.printBoard(0);
		System.out.print("Press enter to continue .... \n\n");
		ans = scan.nextLine();
		game.printRules(2);
		System.out.print("Press enter to continue .... \n\n");
		ans = scan.nextLine();

		System.out.print("Would you like to play with repeats, meaning the computer may (but not necessarily) repeat colors? (Enter y or n): ");
		mode = scan.nextLine();

		while (!(mode.equals("y") || mode.equals("n"))){

			System.out.print("Would you like to play with repeats? (Enter y or n): ");
			mode = scan.nextLine();

		}

		System.out.println("\n");

		boolean repeats;

		if (mode.equals("y")){
			repeats = true;
		}
		else{
			repeats = false;
		}

		game.setComputerBoard(repeats);

		boolean win = false;
		// Keep on looping until the game ends or until 4 reds are found --> the same process should occur in each loop
		for (int i = 0; i < 9; i++){
			game.printBoard();
			System.out.println("You may enter R, Y, O, G, B, P, W");
			System.out.print("Enter your guess as a string without spaces: ");
			ans = scan.nextLine();
			ans = ans.toUpperCase();

			while (game.isInvalid(ans)){ // isInvalid returns a boolean until the the checking is complete
				ans = scan.nextLine();
			}


			// this manages the user interface however each off the functions handle making the screen look nice
			redPins = game.addPlayerGuess(ans);
			game.printBoard();
			game.incrementRowCounter();
			System.out.println("\n\n\n\n");

			// game should end if the number of redPins should be 4
			if (redPins == 4){
				game.printComputerBoard();
				System.out.println("\nYou Win!!");
				break;
			}

			if (i == 8){
				game.printComputerBoard();
				System.out.println("\nYou Lose. Better luck next time!\n");
			}

		}

	}


}
