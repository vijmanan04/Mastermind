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
	private static int ROWS = 9;
	private static int COLUMNS = 8;
	private ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>(); // 4 secret pins and 4 score locations
	private ArrayList<String> computerBoard = new ArrayList<String>();
	private String[] options = {"R", "Y", "O", "G", "B", "P", "W"};
	private int rowTracker = 0;
	
	public void printRules(){
	}
	
	public void setBoard(){
		for (int i = 0; i < ROWS; i++){
			board.add(new ArrayList<String>());
			for (int j = 0; j < COLUMNS; j++){
				if (j >= 4){
					board.get(i).add(j, " - ");
				}
				else{
					board.get(i).add(j, " x ");
				}
			}
		}
		
	}
	
	public void printBoard(){
		for (int i = 0; i < ROWS; i++){
			System.out.println(board.get(i));
		}
	}
	
	public void setComputerBoard(){
		for (int i = 0; i < COLUMNS - 4; i++){
			int marker = (int) (Math.random() * (7));
			computerBoard.add(i, options[marker]);
		}
		System.out.println(computerBoard);
	}
	
	public void addPlayerGuess(String guess){
		int numWhite = 0;
		int numRed = 0;
		for (int i = 0; i < guess.length(); i++){
			board.get(rowTracker).set(i, " " + guess.substring(i, i+1) + " ");
		}
		
		
		// find number of white and red pins
		for (int i = 0; i < guess.length(); i++){
			for (int j = 0; j < computerBoard.size(); j++){
				if (guess.substring(i, i + 1).equals(computerBoard.get(j)) && i == j){
					numRed++;
				}
				if (guess.substring(i, i + 1).equals(computerBoard.get(j)) && i != j){
					numWhite++;
				}
			}
		}
		for (int i = 0; i < numWhite; i++){
			board.get(rowTracker).set(i+4, " w ");
		}
		for (int i = 0; i < numRed; i++){
			board.get(rowTracker).set(i+4, " r ");
		}
		
		rowTracker++;
	}
	
	

	
}

