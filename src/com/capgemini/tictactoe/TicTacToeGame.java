package com.capgemini.tictactoe;
import java.util.*;
public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Welcome to the tictactoe problem");
		Scanner sc = new Scanner(System.in);
		char board[] = createArray();
		char player = chooseCharacter(sc);
		char computer = (player == 'X') ? 'O' : 'X';
		System.out.println("Character chosen by computer= "+computer);
		board=userInput(board,sc,player);
		System.out.println("After user entry the board looks like");
		validBoardCells(board);
	}
	// initialize char array for the game
	public static char[] createArray() {
		char board[] = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}
	// take the character to be played by user as input
	public static char chooseCharacter(Scanner sc) {
		System.out.println("Enter the character to be chosen by user");
		char ch = sc.next().charAt(0);
		sc.nextLine();
		String temp = "" + ch;
		temp.toUpperCase();
		return temp.charAt(0);
	}
	// display valid cells to help the user make his move
	public static void validBoardCells(char board[]) {
		System.out.println(board[1] + " " + board[2] + " " + board[3]);
		System.out.println("                                ");
		System.out.println(board[4] + " " + board[5] + " " + board[6]);
		System.out.println("                                ");
		System.out.println(board[7] + " " + board[8] + " " + board[9]);
	}
	// user input into the board
	public static char[] userInput(char board[], Scanner sc, char player) {
		while (true) {
			System.out.println("Enter the position that you want to play");
			int pos = sc.nextInt();
			if (pos < 1 || pos > 9) {
				System.out.println("Invalid position, Enter again");
				continue;
			} 
			else {
				if (board[pos] != ' ')
					System.out.println("Enter again as position is filled");
				else {
					board[pos] = player;
					break;
				}
			}
		}
		return board;
	}
}