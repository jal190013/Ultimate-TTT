package ultittt;

public class Board {
	
	private TinyBoard[] boards = new TinyBoard[9];
	Board()
	{
		for(int i = 0; i < 9; i++)
		{
			boards[i] = new TinyBoard();
		}
	}
	
	public void print()
	{
		for(int i = 0; i < 9; i+=3)
		{
			System.out.println("     Board#" + i + " | " + boards[i].print(1) + "   Board#" + (i + 1) + " | " + boards[i+1].print(1) + "   Board#" + (i + 2) + " | " + boards[i+2].print(1));
			System.out.println("     Board#" + i + " | " + boards[i].print(2) + "   Board#" + (i + 1) + " | " + boards[i+1].print(2) + "   Board#" + (i + 2) + " | " + boards[i+2].print(2));
			System.out.println("     Board#" + i + " | " + boards[i].print(3) + "   Board#" + (i + 1) + " | " + boards[i+1].print(3) + "   Board#" + (i + 2) + " | " + boards[i+2].print(3));
			System.out.println();
		}
	}
	
	public boolean isEmpty(int board, int square)
	{
		return boards[board].isEmpty(square);
	}
	
	public void setSquare(int board, int square, String mark)
	{
		boards[board].setSquare(square, mark);
	}
	
	public void printWinners()
	{
		for(int i = 0; i < 9; i++)
		{
		
			if(boards[i].getIsWinner() != "UNKNOWN")
			{
				System.out.println("The Board#" + i + " winner is " + boards[i].getIsWinner());
			}
		}
		System.out.println();
	}
	
	public void printFinalWinners()
	{
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < 9; i++)
		{
			if(boards[i].getIsWinner() == "X")
			{
				count1++;
			}
			else if(boards[i].getIsWinner() == "O")
			{
				count2++;
			}
	
		}
		
		if(count1 > count2)
		{
			System.out.println("Game winner is : X");
		}
		else if(count1 < count2)
		{
			System.out.println("Game winner is : O");
		}
		else
		{
			System.out.println("Game winner is : Tie");
		}
	}
	
	public void callChecks()
	{
		
		for(int i = 0; i < 9; i++)
		{
			boards[i].checkRows();
			boards[i].checkCols();
			boards[i].checkDiagLR();
			boards[i].checkDiagRL();
			
		}
	}
	
	public boolean countWinners()
	{
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < 9; i++)
		{
			if(boards[i].getIsWinner() == "X")
			{
				count1++;
			}
			else if(boards[i].getIsWinner() == "O")
			{
				count2++;
			}
		}
		if(count1 >= 5 || count2 >= 5)
		{
			return true;
		}
		return false;
	}
}
