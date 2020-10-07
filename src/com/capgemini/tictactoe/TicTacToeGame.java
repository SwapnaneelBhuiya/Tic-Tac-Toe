package com.capgemini.tictactoe;

import java.util.*;
public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Welcome to the tictactoe problem");
		char board[] = createArray();
		char player = chooseCharacter();
		char computer=(player=='X')?'O' : 'X';
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
	public static char chooseCharacter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the character to be chosen by user");
		char ch = sc.next().charAt(0);
		sc.nextLine();
		String temp = "" + ch;
		temp.toUpperCase();
		return temp.charAt(0);
	}
}
