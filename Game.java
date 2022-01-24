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
		MasterMind game = new MasterMind();
		Scanner scan = new Scanner(System.in);
		String ans;
		
		game.setBoard();
		game.setComputerBoard();
		game.printBoard();
		
		boolean win = false;
		for (int i = 0; i < 9; i++){
			System.out.print("Enter your guess as a string: ");
			ans = scan.nextLine();
			game.add(ans);
			game.printBoard();
		}
		
	}
}

