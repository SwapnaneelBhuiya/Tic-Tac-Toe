package com.workshop.tictactoe;

public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Welcome to the tictactoe problem");
		createArray();
	}

	// method for UC1 where we initialize the char array for tictactoe
	public static void createArray() {
		char board[] = new char[10];
		for (int pos = 1; pos < 10; pos++) {
			board[pos] = ' ';
		}
	}
}