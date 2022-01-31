/*
 * MasterMind.java
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
import java.util.ArrayList;

public class MasterMind {
	private int rowPrintCounter = 1;
	private static int ROWS = 9;
	private static int COLUMNS = 8;
	private ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>(); // 4 secret pins and 4 score locations
	private ArrayList<String> computerBoard = new ArrayList<String>();
	private ArrayList<String> options = new ArrayList<String>();
	private String boardDisplay = board.toString();

	public MasterMind(){
		options.add("R");
		options.add("Y");
		options.add("O");
		options.add("G");
		options.add("B");
		options.add("P");
		options.add("W");
	}

	private int rowTracker = 0;
	private int[] ix = {-1, -1, -1, -1};

	public void printRules(){
	}

	public void incrementRowCounter(){
		rowPrintCounter++;
	}

	public void setBoard(){ //set up the board and populate
		for (int i = 0; i < 2 * ROWS; i++){
			board.add(new ArrayList<String>());
			if (i % 2 == 1){
				for (int j = 0; j < COLUMNS; j++){
					if (j == 6 || j == 7){
						board.get(i).add(j, " _ ");
					}
					else if (j == 4 || j == 5){
						board.get(i).add(j,  "     ");
					}

					else{
						board.get(i).add(j, "   ");
					}

				}
			}
			else{
				for (int j = 0; j < COLUMNS; j++){
					if (j == 4 || j == 5){
						board.get(i).add(j, "     ");
					}
					else if (j == 6 || j == 7){
						board.get(i).add(" _ ");
					}
					else{
						board.get(i).add(j, " ? ");
					}
				}
			}
		}

	}

	public void printBoard(){
		//System.out.println(rowPrintCounter);
		System.out.println("     Player Guess                    Pins");
		for (int i = 0; i < 2 * rowPrintCounter; i++){
			boardDisplay = board.get(i).toString().replace(",", " ").replace("[", "|").replace("]", "|");
			System.out.print(boardDisplay);
			if (i == 2 * rowPrintCounter - 2){
				System.out.println("\t <------Current Guessing Row: " + (i / 2 + 1) );
			}
			else if (i != 2 * rowPrintCounter - 2){
				System.out.println();
			}
			if (i % 2 == 1){
				System.out.println("|------------------------------------------|");
			}
		}
	}

	public void setComputerBoard(){ // randomly generate computer code
		int counter  = 0;
		while (options.size() != 3){
			int marker = (int) (Math.random() * (options.size()));
			computerBoard.add(counter, options.get(marker));
			options.remove(marker);
			counter++;
		}

		//System.out.println(computerBoard);
	}

	public int addPlayerGuess(String guess){ // get player guesses as a string and add it to the board
		guess = guess.toUpperCase();
		for (int i = 0; i < guess.length(); i++){
			board.get(rowTracker).set(i, " " + guess.substring(i, i+1) + " ");
		}

		/*
		// find number of white and red pins
		for (int j = 0; j < computerBoard.size(); j++){ // count the total number of red and white pins
			for (int i = j; i < guess.length(); i++){
				if (guess.substring(i, i + 1).equals(computerBoard.get(j)) && i == j){ // if the position is the same, add to red pins
					numRed++;

				}
				if (guess.substring(i, i + 1).equals(computerBoard.get(j)) && i != j){ // if color is the same, add to white pins
					numWhite++;
					System.out.println("Guess Index: " + i + " = " + guess.substring(i, i + 1));
					System.out.println("Computer Index: " + j + " = " + computerBoard.get(j));
				}
			}
		}
		*/

		int numRed = 0;
		int yC = 0;
		int oC = 0;
		int gC = 0;
		int bC = 0;
		int pC = 0;
		int wC = 0;
		int rC = 0;
		int numWhite = 0;

		for (int i = 0; i < guess.length(); i++){
			if(guess.substring(i, i + 1).equals("R")){
				rC++;
			}
				else if(guess.substring(i, i + 1).equals("Y")){
				yC++;
			}
				else if(guess.substring(i, i + 1).equals("O")){
				oC++;
			}
				else if(guess.substring(i, i + 1).equals("G")){
				gC++;
			}
				else if(guess.substring(i, i + 1).equals("B")){
				bC++;
			}
				else if(guess.substring(i, i + 1).equals("P")){
				pC++;
			}
				else if(guess.substring(i, i + 1).equals("W")){
				wC++;
			}
		}

		for (int i = 0; i < computerBoard.size(); i++){
			if(computerBoard.get(i).equals("R") && rC>0 ){
				numWhite++;
				rC--;
			}
				else if(computerBoard.get(i).equals("Y") && yC>0){
				numWhite++;
				yC--;
			}
				else if(computerBoard.get(i).equals("O") && oC>0){
				numWhite++;
				oC--;
			}
				else if(computerBoard.get(i).equals("G") && gC>0){
				numWhite++;
				gC--;
			}
				else if(computerBoard.get(i).equals("B") && bC>0){
				numWhite++;
				bC--;
			}
				else if(computerBoard.get(i).equals("P") && pC>0){
				numWhite++;
				pC--;
			}
				else if(computerBoard.get(i).equals("W") && wC>0){
				numWhite++;
				wC--;
			}
		}

		for(int i = 0; i < computerBoard.size(); i++){ //Counts Num of Red pins
			if(guess.substring(i, i + 1).equals(computerBoard.get(i))){
				numRed++;
			}
		}
		numWhite -= numRed;
		// System.out.println("Num Red: " + numRed + " Num White: " + numWhite);
		int totalPlaceCounter = 0; // total counter keeps looping for both red and white pins so I can place red and white pins in one loop

		while (totalPlaceCounter != (numRed + numWhite)){ // place red pins first
			for (int i = 0; i < numRed; i++){
				if (totalPlaceCounter < 2){ // used to prevent index out of bounds error because use two rows to place pins
					if (board.get(rowTracker).get(totalPlaceCounter+6).equals(" _ ")){
						board.get(rowTracker).set(totalPlaceCounter+6, " r ");
						totalPlaceCounter++; //  add to place counter when a place occurs to mark position that has been placed
					}
				}
				else if (board.get(rowTracker + 1).get(totalPlaceCounter+6 - 2).equals(" _ ")){ // used to prevent index out of bounds error because use two rows to place pins
					board.get(rowTracker + 1).set(totalPlaceCounter + 6 - 2, " r ");
					totalPlaceCounter++; //  add to place counter when a place occurs to mark position that has been placed
				}
			}

			for (int i = 0; i < numWhite; i++){ // place white pins next
				if (totalPlaceCounter < 2){
					if (board.get(rowTracker).get(totalPlaceCounter+6).equals(" _ ")){
						board.get(rowTracker).set(totalPlaceCounter+6, " w ");
						totalPlaceCounter++; //  add to place counter when a place occurs to mark position that has been placed
					}
				}

				else if (board.get(rowTracker + 1).get(totalPlaceCounter+6 - 2).equals(" _ ")){
					board.get(rowTracker + 1).set(totalPlaceCounter + 6 - 2, " w ");
					totalPlaceCounter++; //  add to place counter when a place occurs to mark position that has been placed
				}
			}
		}
		/*
		for (int i = 0; i < numRed; i++){
			if (i < 2 && board.get(rowTracker).get(i+6).equals(" _ ") && !board.get(rowTracker).get(i+6).equals(" r ")){
				System.out.println("Red loop if: " + i);
				board.get(rowTracker).set(i+6, " r ");
			}
			else{
				System.out.println("Red loop else: " + i);
				board.get(rowTracker + 1).set(i+6, " r ");
			}

			for (int i = 0; i < 2; i++){
				if (!board.get(rowTracker).get(i + 6).equals(" _ ")){
					firstFilled++;
				}
			}
		}
		for (int i = 0; i < numWhite; i++){
			//System.out.print(board.get(rowTracker).get();
			if (firstFilled < 2 && board.get(rowTracker).get(i+6).equals(" _ ") && !board.get(rowTracker).get(i+6).equals(" r ") && !board.get(rowTracker).get(i+6).equals(" w ")){
				System.out.println("White loop if: " + i);
				board.get(rowTracker).set(i+6, " w ");
			}
			else{
				System.out.println("White loop else: " + i);
				board.get(rowTracker + 1).set(i+6, " w ");
			}
		}
		*/
		rowTracker += 2; // increment row by two becuase use 2 rows per turn

		return numRed;
	}




}
