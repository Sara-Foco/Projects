package easyProjects;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGameEasy {
	
	static String[] board; // create the String[] board
	static String turn; // create the string turn
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		turn = "X"; // turn begins from X
		String winner = null; // initialize the winner to null until I found the winner
		
		board = new String[9];
		for (int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i+1);
		} // create the board with 8 numbers from 1 to 9
		System.out.println("TIC TAC TOE GAME!!");
		printBoard(); // print the initial board
		System.out.println("X will play first, type the number of the slot where you wanna insert the X:");
		
		while (winner == null) { // while the winner is null
			try {
				int slot = scan.nextInt();
				if (slot < 1 && slot > 9) {
					System.out.println("YOU MUST TYPE A VALID SLOT NUMBER!!");
					continue;
				} // if the number entered is less then 1 or greater then 9 print an error and repeat the type 
				
				if (board[slot-1].equals(String.valueOf(slot))) { // if the slot is equals then the number typed (is not X or O)
					board[slot-1] = turn; // write X or O
					turn = turn.equals("X") ? "O" : "X"; // skip to the other player
					printBoard(); // print the updated board
					winner = checkWinner(); // check if there is a winner
				} else {
					System.out.println("Slot is already taken!! Choose another slot"); // if the slot is X or O it's already taken so choose another one
				}
				
			} catch (InputMismatchException e) { // if the type isn't correct generate an error
				System.out.println("Invalid input!! Re-enter the NUMBER of the slot:");
				scan.nextLine();
			}
		}
		
		if (winner.equals("draw")) { // if winner is draw so the game end without a winner
			System.out.println("It's a draw!!");
		} else {
			System.out.println("Congratulation!! " + winner + " won!!"); // print the winner
		}
		
		scan.close();
	}

//	Method to print the board, I will use it every time to print the updated board
	static void printBoard() {
		System.out.println("|"+"-".repeat(11)+"|"); // use repeat method to print '-' on the top of the board
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|"+"-".repeat(11)+"|");
	}
	
//	Method to check the winner. I check if the line is 'XXX', 'OOO' or if it doesn't have equals signs
	private static String checkWinner() {
		for (int i = 0; i < 8; i++) {
			String line = null; // I Initialize the line to null for check the winner 
			switch (i) {
			case 0:
				line = board[0] + board[1] + board[2]; // check the first line (in original with numbers 1,2,3)
				break;
				
			case 1:
				line = board[3] + board[4] + board[5]; // check the second line (in original with numbers 4,5,6)
				break;
				
			case 2:
				line = board[6] + board[7] + board[8]; // check the third line (in original with numbers 7,8,9)
				break;

			case 3:
				line = board[0] + board[3] + board[6]; // check the first column (in original with numbers 1,4,7)
				break;

			case 4:
				line = board[1] + board[4] + board[7]; // check the second column (in original with numbers 2,5,8)
				break;

			case 5:
				line = board[2] + board[5] + board[8]; // check the third column (in original with numbers 3,6,9)
				break;

			case 6:
				line = board[0] + board[4] + board[8]; // check the first diagonal (in original with numbers 1,5,9)
				break;

			case 7:
				line = board[2] + board[4] + board[6]; // check the second diagonal (in original with numbers 3,5,7)
				break;
			}
			if (line.equals("XXX")) {
				return "X"; // if line is XXX the winner is X
			} else if (line.equals("OOO")) {
				return "O"; // if line is OOO the winner is O
			}
		}
		
		for (int i = 0; i < board.length; i++) { // check all the slots in the board
			if (Arrays.asList(board).contains(String.valueOf(i+1))) { // check if there is at least one number on the board
				break; // if there is a number continue the game
			} else if (i == 8) { // if it reaches the very last index without finding any number it is a draw 
				return "draw";
			}
		}
		
//		If I don't have a winner yet continue playing
		System.out.println(turn + "'s turn, enter a slot number to place " + turn + " in:"); 
		return null;
	}

}