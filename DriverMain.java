/*
 * 	Austin Leonhardt - CE 2336.001
 *
 * 		Analysis:
 * 			This project was designed to tackle the less than simple inheritance between different objects in a TIC TAC TOE game. The objects are 
 * 			players, boards, and game(rules). In this version however, the board is made up of other boards to create an Ultimate TIC TAC TOE game with a 
 * 			unique set of rules.
 * 
 * 		Design:
 * 			DriverMain
 * 				No Functions
 * 			Game
 * 				start
 * 				gameOver
 * 				switchPlayers
 * 				setHumans
 * 				invalid
 * 				callMove
 * 				callBoard
 * 			Board
 * 				print
 * 				isEmpty
 * 				setSquare
 * 				printWinners
 * 				printFinalWinners
 * 				callChecks
 * 				countWinners
 * 			TinyBoard
 * 				print
 * 				isEmpty
 * 				setSquare
 * 				getIsWinner
 * 				setWinner
 * 				checkRows
 * 				checkCols
 * 				checkDiagLR
 * 				checkDiagRL
 * 				updateValues
 * 			Player
 * 				setVal
 * 				getName
 * 				setName
 * 				getMark
 * 				setMark
 * 				makeMove
 * 				chooseBoard
 * 			ComputerPlayer
 * 				randomMoveD
 * 
 */
package ultittt;

import java.util.Scanner;

public class DriverMain {

	public static void main(String[] args) {
		
		int player1, player2;
		Scanner input = new Scanner(System.in);
		
		Game game = new Game();
		
		System.out.println("Please select player 1 (1 = Human, 2 = Computer): ");
		player1 = input.nextInt();
		System.out.println("Please select player 2 (1 = Human, 2 = Computer): ");
		player2 = input.nextInt();
		
		game.setHumans(player1, player2);
		
		game.start();

	}

}

