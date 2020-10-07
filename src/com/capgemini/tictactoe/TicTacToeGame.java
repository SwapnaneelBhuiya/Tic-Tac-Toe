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
		int num=checkStart();
		if(num==1)
			System.out.println("User will start first");
		else
			System.out.println("Computer will start first");
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
			if (checkFreeSpace(board, pos)) {
				board[pos] = player;
				break;
			} else
				System.out.println("Enter again as position is filled or invalid");
		}
		return board;
	}
	//check the presence of free space
	public static boolean checkFreeSpace(char board[], int pos) {
		if (pos < 1 || pos > 10)
			return false;
		else {
			if (board[pos] == ' ')
				return true;
			else
				return false;
		}
	}
	//test who will begin first
	public static int checkStart()
	{
		int num=(int)((Math.random()*2)+1);
		return num;
	}
}