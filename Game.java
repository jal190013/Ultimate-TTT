package ultittt;

public class Game {
	
	private String[] marks = {"X", "O"};
	private String name = "ULTIMATE TIC-TAC-TOE";
	// Player Selections: (Player)
	
	private Player[] players = new Player[2];
	private boolean[] isHuman = new boolean[2];
	
	// ---------------------------------------------------------
	private int currentBoard;
	private int currentMove;
	private int currentPlayerIndex = -1;
	
	
	
	private Board board = new Board();
	
	public void start()
	{
		players[0] = new Player();
		players[1] = new Player();
		
		players[0].setVal("Player 1", marks[0]);
		players[1].setVal("Player 2", marks[1]);
		
		System.out.println("===== WELCOME TO THE " + name + "!! =====");
		board.print();
		//First board selection
		switchPlayer();
		System.out.println("Current Player is : " + players[currentPlayerIndex].getName());
		
		callBoard();
		callMove();
		
		System.out.println("Selected Square : " + currentMove);
		
		do
		{
			board.print();
			board.printWinners();
			System.out.println();
			switchPlayer();
			System.out.println("Current Player is : " + players[currentPlayerIndex].getName());
			System.out.println("Selected Board : " + currentBoard);
			callMove();
			System.out.println("Selected Square : " + currentMove);
			currentBoard = currentMove;
			
			
			
		}while(!gameOver());
		board.print();
		board.printWinners();
		board.printFinalWinners();
	}
	
	private boolean gameOver()
	{
		board.callChecks();
		
		if(board.countWinners())
		{
			return true;
		}
		
		return false;
	}
	
	private void switchPlayer()
	{
		if(this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1)
		{
			this.currentPlayerIndex = 0;
		}
		else
		{
			this.currentPlayerIndex = 1;
		}
	}
	
	public void setHumans(int P1, int P2)
	{
		if(P1 == 1)
		{
			isHuman[0] = true;
		}
		else if(P1 == 2)
		{
			isHuman[0] = false;
		}
		if(P2 == 1)
		{
			isHuman[1] = true;
		}
		else if(P2 == 2)
		{
			isHuman[1] = false;
		}
		
	}
	
	public void invalid()
	{
		System.out.println("Invalid Input");
	}
	
	public void callMove()
	{
		do
		{
			System.out.println("Please select a valid square on the selected board (0-8): ");
			currentMove = players[currentPlayerIndex].makeMove(isHuman[currentPlayerIndex]);
			if((currentMove < 0 || currentMove > 9) || !(board.isEmpty(currentBoard, currentMove)))
			{
				invalid();
			}
		}while(currentMove < 0 || currentMove > 9);
		board.setSquare(currentBoard, currentMove, players[currentPlayerIndex].getMark());
	}
	
	public void callBoard()
	{
		do
		{
			System.out.print("Please select a valid board (0-8): ");
			currentBoard = players[currentPlayerIndex].chooseBoard(isHuman[currentPlayerIndex]); 
			if(currentBoard < 0 || currentBoard > 9)
			{
				invalid();
			}
		}while(currentBoard < 0 || currentBoard > 9);
		
	}
	
	
}
