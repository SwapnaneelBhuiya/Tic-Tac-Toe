package com.capgemini.tictactoe;

public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Welcome to the tictactoe problem");
		createArray();
	}

	// initialize char array for the game
	public static void createArray() {
		char board[] = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}
}
