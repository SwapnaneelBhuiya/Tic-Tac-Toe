package com.capgemini.tictactoe;
import java.util.*;
public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Welcome to the tictactoe problem");
		Scanner sc = new Scanner(System.in);
		while (true) {
			char board[] = createArray();
			char player = chooseCharacter(sc);
			char computer = (player == 'X') ? 'O' : 'X';
			System.out.println("Character chosen by computer= " + computer);
			int num = checkStart();
			if (num == 1) {
				System.out.println("User will start first");
				board = userInput(board, sc, player);
			} else {
				System.out.println("Computer will start first");
				board = computerInput(board, computer);
			}
			int move;
			while (true) {
				if (num == 1) {
					board = computerInput(board, computer);
					int checkOpp = checkOpponent(board, computer);
					if (checkOpp == 1) {
						System.out.println("Opponent is winning, enter accordingly");
						userInput(board, sc, player);
					} else {
						if (board[1] == ' ')
							board[1] = player;
						else if (board[3] == ' ')
							board[3] = player;
						else if (board[7] == ' ')
							board[7] = player;
						else if (board[9] == ' ')
							board[9] = player;
						else if(board[5]==' ')
							board[5]=player;
						else
							userInput(board,sc,player);
					}
				}
				else
				{
					int checkOpp = checkOpponent(board, computer);
					if (checkOpp == 1) {
						System.out.println("Opponent is winning, enter accordingly");
						userInput(board, sc, player);
					} else {
						if (board[1] == ' ')
							board[1] = player;
						else if (board[3] == ' ')
							board[3] = player;
						else if (board[7] == ' ')
							board[7] = player;
						else if (board[9] == ' ')
							board[9] = player;
						else if(board[5]==' ')
							board[5]=player;
						else
							userInput(board,sc,player);
					}
					board=computerInput(board,computer);
				}
				validBoardCells(board);
				move=checkTurns(board,player,computer);
				if(move==1)
				{
					System.out.println("User wins");
					break;
				}
				else if(move==2)
				{
					System.out.println("Computer Wins");
					break;
				}
				else if(move==3)
				{
					System.out.println("Match tied");
					break;
				}
				else
					continue;
			}
			System.out.println("Do you want to play again? Press Y/N");
			char choice = sc.next().charAt(0);
			if (choice == 'Y')
				continue;
			else
				break;
		}
	}
	//check if opponent can win
	public static int checkOpponent(char board[], char opp) {
		if ((board[1] == opp && board[3] == opp && board[7] == opp)
				|| (board[1] == opp && board[9] == opp && board[7] == opp)
				|| (board[3] == opp && board[9] == opp && board[7] == opp))
			return 1;
		else {
			for (int pos = 1; pos < 10; pos++)
				if (board[pos] == opp && board[pos+1] == opp)
					return 1;
				else if (board[pos] == opp && board[pos + 3] == opp)
					return 1;
				else if (board[pos] == opp && board[pos + 4] == opp)
					return 1;
				else
					continue;
		}
		return 0;
	}
	//Computer will make a move
	public static char[] computerInput(char board[], char computer) {
		while (true) {
			int pos = (int) ((Math.random() * 9) + 1);
			if (checkFreeSpace(board, pos)) {
				board[pos] = computer;
				break;
			}
		}
		return board;
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
	//check tie or win or change turn
	public static int checkTurns(char board[],char player,char computer) {
		int x = 0, or = 0, count_x = 0, count_y = 0;
		for (int pos = 1; pos < 10; pos++) {
			if (board[pos] == player) {
				if ((board[pos + 1] == player && board[pos + 2] == player) || (board[pos + 4] == player && board[pos + 8] == player)
						|| (board[pos + 3] == player && board[pos + 6] == player))

				{
					x = 1;
					break;
				}
				count_x++;
			} else if (board[pos] == computer) {
				if ((board[pos + 1] == computer && board[pos + 2] == computer) || (board[pos + 4] == computer && board[pos + 8] == computer)
						|| (board[pos + 3] == computer && board[pos + 6] == computer)) {
					or = 1;
					break;
				}
				count_y++;
			} else
				continue;
		}
		if (x == 1)
			return 1;
		else if (or == 1)
			return 2;
		else if (count_x >= 3 && count_y >= 3)
			return 3;
		else
			return 4;
	}
}
