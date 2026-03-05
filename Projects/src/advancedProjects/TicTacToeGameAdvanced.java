package advancedProjects;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGameAdvanced {
	
//	Initialize the grid
	static char[][] board = {
			{' ', ' ', ' '},
			{' ', ' ', ' '},
			{' ', ' ', ' '}
	};
//	set the user and the computer
	static char user = 'X';
	static char computer = 'O';
	static boolean winner = false;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // scanner for user input
		Random rand = new Random(); // random for computer choice
		boolean continueGame = true;

		do {
			
			resetBoard();
			game(scan, rand);
			
			System.out.println("Do you want to play again? (Press ENTER to continue, type 'NO' to quit):");
			String choice = scan.nextLine();
			
			if (choice.equalsIgnoreCase("no")) {
				System.out.println("Thanks for playing, goodbye!!");
				continueGame = false;
			}
			
			scan.nextLine();
			
		} while (continueGame);
		
		
	}
	
	private static void game(Scanner scan, Random rand) {
		boolean inGame = true; // boolean for the game, it will end when there are no free boxes
		
		System.out.println("Tic Tac Toe Game!!");

		System.out.println("You are X, Computer is O.");
		
		while (inGame) {
			printBoard();
			
//			User turn
			
			System.out.println("It's your turn. Enter the row and then the column where you wanna place X (0-2):");
			int row = scan.nextInt();
			int col = scan.nextInt();
			
//			check if the move is valid
			if (validMove(row, col)) {
				board[row][col] = user; // mark the X in the corresponding box
				
//				check if user wins
				if (checkWinner(user)) {
					winner = true;
					printBoard();
					System.out.println("Congratulation!! You won!!");
					inGame = false;
					break;
				}
			} else {
				System.out.println("Your move is not valid!! Try again!!");
				continue;
			}
			
//			check if it is a draw
			if (fullBoard() && !winner) {
				printBoard();
				System.out.println("The board is full!! It's a draw!! ");
				inGame = false;
				break;
			}
			
//			Computer turn
			
			System.out.println("Computer turn:");
			computerMove(rand);
			if (checkWinner(computer)) {
				winner = true;
				printBoard();
				System.out.println("Computer wins!!!");
				inGame = false;
				break;
			}
			
			if (fullBoard() && !winner) {
				printBoard();
				System.out.println("The board is full!! It's a draw!! ");
				inGame = false;
				break;
			}
			
		}
	}

//	method to print the updated board after every turn
	private static void printBoard() {
		System.out.println("   0   1   2 ");
		System.out.println(" |" + "-".repeat(11) + "|");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length-2; j++) {
				System.out.println(i + "| " + board[i][j] + " | " + board[i][j+1] + " | " + board[i][j+2] + " |");
			}
			if (i == board.length-1) {
				break;
			}
			System.out.println(" |---|---|---|");
		}
		System.out.println(" |" + "-".repeat(11) + "|");
		
	}
	
//	check if row and column is between 0 and 2
	private static boolean validMove(int row, int col) {
		return row >= 0 && row <= 2 && col >= 0 && col <=2 && board[row][col] == ' ';
	}

	private static boolean checkWinner(char symbol) {
//		check if rows have three equals symbols
		for (int i = 0; i < 3; i++) {
			boolean fullRow = true;
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != symbol) {
					fullRow = false;
					break;
				}
			}
			if (fullRow) return true;
		}
		
//		check if columns have three equals symbols
		for (int i = 0; i < 3; i++) {
			boolean fullCol = true;
			for (int j = 0; j < 3; j++) {
				if (board[j][i] != symbol) {
					fullCol = false;
					break;
				}
			}
			if (fullCol) return true;
		}
		
//		check if diagonals have three equals symbols
		return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
	}

//	check if the board is full
	private static boolean fullBoard() {
		for (char[] row : board) {
			for (char box : row) {
				if (box == ' ') return false;
			}
		}
		return true;
	}

//	create computer move
	private static void computerMove(Random rand) {
//		initialize row and column
		int row, col;
		do {
//			assign a random number from 0 to 2 for the row and one for the column
			row = rand.nextInt(3);
			col = rand.nextInt(3);
		} while (!validMove(row, col)); // continue until it is a valid move
		board[row][col] = computer; // if it is valid mark the O in the corresponding box 
	}
	
//	method to clean the board after every game
	private static void resetBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

}
