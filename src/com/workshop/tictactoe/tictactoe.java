package com.workshop.tictactoe;
public class TicTacToeGame {
	public static void main(String args[])
	{
		System.out.println("Welcome to the tictactoe problem");
		TicTacToeGame obj=new TicTacToeGame();
		obj.create_char_array_for_game();
	}
	public static void create_char_array_for_game()
	{
		char board[]=new char[10];
		for(int i=1;i<10;i++)
		{
			board[i]=' ';
		}
	}

}
