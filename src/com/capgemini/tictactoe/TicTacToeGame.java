package com.capgemini.tictactoe;

import java.util.*;
public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Welcome to the tictactoe problem");
		Scanner sc = new Scanner(System.in);
		char board[] = createArray();
		char player = chooseCharacter(sc);
		char computer=(player=='X')?'O' : 'X';
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
	//take the character to be played by user as input
	public static char chooseCharacter(Scanner sc) {
		System.out.println("Enter the character to be chosen by user");
		char ch = sc.next().charAt(0);
		sc.nextLine();
		String temp = "" + ch;
		temp.toUpperCase();
		return temp.charAt(0);
	}
	//display valid cells to help the user make his move
	public static void validBoardCells(char board[])
	{
		System.out.println(board[1]+" "+board[2]+" "+board[3]);
		System.out.println("                                ");
		System.out.println(board[4]+" "+board[5]+" "+board[6]);
		System.out.println("                                ");
		System.out.println(board[7]+" "+board[8]+" "+board[9]);
	}
}