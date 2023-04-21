package ultittt;

public class TinyBoard {
	
	private String[] tBoard = new String[9];
	private String isWinner = "UNKNOWN";
	private boolean full = false;
	
	TinyBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			tBoard[i] = Integer.toString(i);
		}
	}
	
	public String print(int row)
	{
		int index = 0;
		if(row == 1)
		{
			index = 0;
		}
		else if(row == 2)
		{
			index = 3;
		}
		else if(row == 3)
		{
			index = 6;
		}
		
		return tBoard[index] + " | " + tBoard[index + 1] + " | " + tBoard[index + 2] + " | ";

	}
	
	public boolean isEmpty(int num)
	{
		if(tBoard[num].charAt(0) >= 'O' && tBoard[num].charAt(0) < '9' || tBoard[num].charAt(0) != '*' || tBoard[num].charAt(0) != 'X' || tBoard[num].charAt(0) != 'O')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setSquare(int square, String mark)
	{
		if(!full)
			tBoard[square] = mark;
		
	}

	public String getIsWinner() {
		return isWinner;
	}

	public void setWinner(String isWinner) {
		this.isWinner = isWinner;
	}
	
	public void checkRows()
	{
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < 9; i++)
		{
			
			
			if(tBoard[i] == "X")
			{
				count1++;
			}
			else if(tBoard[i] == "O")
			{
				count2++;
			}
			
			if((i == 2 || i == 5 || i == 8) && count1 == 3)
			{
				this.isWinner = "X";
				updateValues();
			}
			else if((i == 2 || i == 5 || i == 8) && count2 == 3)
			{
				this.isWinner = "O";
				updateValues();
			}
			else if((i == 2 || i == 5 || i == 8))
			{
				count1 = 0;
				count2 = 0;
			}
		}
	}
	
	public void checkCols()
	{
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < 9; i+=3)
		{
			
			if(tBoard[i] == "X")
			{
				count1++;
			}
			else if(tBoard[i] == "O")
			{
				count2++;
			}
			
			if((i == 6 || i == 7 || i == 8) && count1 == 3)
			{
				this.isWinner = "X";
				updateValues();
			}
			else if((i == 6 || i == 7 || i == 8) && count2 == 3)
			{
				this.isWinner = "O";
				updateValues();
			}
			else if((i == 6 || i == 7))
			{
				count1 = 0;
				count2 = 0;
				i -= 8;
			}
		}
		
	}
	
	public void checkDiagLR()
	{
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < 9; i+=4)
		{
			
			if(tBoard[i] == "X")
			{
				count1++;
			}
			else if(tBoard[i] == "O")
			{
				count2++;
			}
		}
		
		if(count1 == 3)
		{
			this.isWinner = "X";
			updateValues();
		}
		else if(count2 == 3)
		{
			this.isWinner = "O";
			updateValues();
		}
			
	}
	
	public void checkDiagRL()
	{
		int count1 = 0, count2 = 0;
		
		for(int i = 2; i < 7; i+=2)
		{
			
			if(tBoard[i] == "X")
			{
				count1++;
			}
			else if(tBoard[i] == "O")
			{
				count2++;
			}
		}
		
		if(count1 == 3)
		{
			this.isWinner = "X";
			updateValues();
		}
		else if(count2 == 3)
		{
			this.isWinner = "O";
			updateValues();
		}
			
	}
	
	public void updateValues()
	{
		for(int i = 0; i < 9; i++)
		{
			if(tBoard[i] != "X" && tBoard[i] != "O")
			{
				tBoard[i] = "*";
			}
		}
		this.full = true;
	}
}	